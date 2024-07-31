package com.gamerum.backend.usecase.service.community.post.impl;

import com.gamerum.backend.adaptor.dto.community.post.comment.CommentCreateDTO;
import com.gamerum.backend.adaptor.dto.community.post.comment.CommentUpdateDTO;
import com.gamerum.backend.external.persistence.relational.entity.Comment;
import com.gamerum.backend.external.persistence.relational.entity.CommunityMember;
import com.gamerum.backend.external.persistence.relational.entity.Post;
import com.gamerum.backend.external.persistence.relational.repository.CommentRepository;
import com.gamerum.backend.external.persistence.relational.repository.CommunityMemberRepository;
import com.gamerum.backend.external.persistence.relational.repository.PostRepository;
import com.gamerum.backend.security.user.UserRole;
import com.gamerum.backend.usecase.exception.NotAllowedException;
import com.gamerum.backend.usecase.exception.NotFoundException;
import com.gamerum.backend.usecase.exception.NotParticipatedException;
import com.gamerum.backend.usecase.service.community.post.CommentService;
import com.gamerum.backend.usecase.service.user.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private CommunityMemberRepository communityMemberRepository;
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private CurrentUser currentUser;

    @Override
    public Comment createComment(Long postId, CommentCreateDTO commentCreateDTO) {
        Post post = postRepository.findById(postId).
                orElseThrow(() -> new NotFoundException("Post"));

        CommunityMember communityMember = communityMemberRepository.
                findByProfileIdAndCommunityId(currentUser.getProfileId(), post.getCommunity().getId()).
                orElseThrow(NotParticipatedException::new);

        return commentRepository.save(Comment.builder()
                .text(commentCreateDTO.getText())
                .profile(communityMember.getProfile())
                .post(post)
                .build());
    }

    @Override
    public List<Comment> getPostComments(Long postId, int page, int size) {
        return commentRepository.findByPostId(postId, PageRequest.of(page, size));
    }

    @Override
    public Comment updateComment(CommentUpdateDTO commentUpdateDTO) {
        Comment comment = commentRepository.findById(commentUpdateDTO.getId()).
                orElseThrow(() -> new NotFoundException("Comment"));

        if (!Objects.equals(comment.getProfile().getId(), currentUser.getProfileId()))
            throw new NotAllowedException();

        comment.setText(commentUpdateDTO.getText());

        return commentRepository.save(comment);
    }

    @Override
    public void deleteComment(Long commentId) {
        Comment comment = commentRepository.findById(commentId).
                orElseThrow(() -> new NotFoundException("Comment"));

        Long profileId = currentUser.getProfileId();

        boolean isAdmin = currentUser.hasRole(UserRole.ROLE_ADMIN);
        boolean isCommentWriter = Objects.equals(comment.getProfile().getId(), profileId);
        boolean isPostWriter = Objects.equals(comment.getPost().getProfile().getId(), profileId);

        if (isAdmin || isCommentWriter || isPostWriter) {
            commentRepository.delete(comment);
            return;
        }

        CommunityMember communityMember = communityMemberRepository.
                findByProfileIdAndCommunityId(profileId, comment.getPost().getCommunity().getId()).
                orElseThrow(NotParticipatedException::new);

        if (communityMember.getRole().equals(CommunityMember.Role.USER))
            throw new NotAllowedException();

        commentRepository.delete(comment);
    }
}
