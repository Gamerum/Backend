package com.gamerum.backend.usecase.service.community.post.impl;

import com.gamerum.backend.adaptor.dto.community.post.comment.response.CommentResponseCreateDTO;
import com.gamerum.backend.adaptor.dto.community.post.comment.response.CommentResponseUpdateDTO;
import com.gamerum.backend.external.persistence.relational.entity.Comment;
import com.gamerum.backend.external.persistence.relational.entity.CommentResponse;
import com.gamerum.backend.external.persistence.relational.entity.CommunityMember;
import com.gamerum.backend.external.persistence.relational.repository.CommentRepository;
import com.gamerum.backend.external.persistence.relational.repository.CommentResponseRepository;
import com.gamerum.backend.external.persistence.relational.repository.CommunityMemberRepository;
import com.gamerum.backend.security.user.UserRole;
import com.gamerum.backend.usecase.exception.NotAllowedException;
import com.gamerum.backend.usecase.exception.NotFoundException;
import com.gamerum.backend.usecase.exception.NotParticipatedException;
import com.gamerum.backend.usecase.service.community.post.CommentResponseService;
import com.gamerum.backend.usecase.service.user.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CommentResponseServiceImpl implements CommentResponseService {

    @Autowired
    private CommentResponseRepository commentResponseRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private CommunityMemberRepository communityMemberRepository;

    @Autowired
    private CurrentUser currentUser;

    @Override
    public CommentResponse createCommentResponse(Long commentId, CommentResponseCreateDTO commentResponseCreateDTO) {
        Comment comment = commentRepository.findById(commentId).
                orElseThrow(() -> new NotFoundException("Comment"));

        Long communityId = comment.getPost().getCommunity().getId();
        Long writerProfileId = currentUser.getProfileId();

        CommunityMember writer = communityMemberRepository.findByProfileIdAndCommunityId(writerProfileId, communityId)
                .orElseThrow(NotParticipatedException::new);

        return commentResponseRepository.save(CommentResponse.builder()
                .text(commentResponseCreateDTO.getText())
                .comment(comment)
                .profile(writer.getProfile())
                .build());
    }

    @Override
    public List<CommentResponse> getCommentResponses(Long commentId, int page, int size) {
        return commentResponseRepository.findByCommentId(commentId, PageRequest.of(page, size));
    }

    @Override
    public CommentResponse updateCommentResponse(CommentResponseUpdateDTO commentResponseUpdateDTO) {
        CommentResponse commentResponse = commentResponseRepository
                .findById(commentResponseUpdateDTO.getId())
                .orElseThrow(() -> new NotFoundException("Comment Response"));

        if (!Objects.equals(commentResponse.getProfile().getId(), currentUser.getProfileId()))
            throw new NotAllowedException();

        commentResponse.setText(commentResponseUpdateDTO.getText());

        return commentResponseRepository.save(commentResponse);
    }

    @Override
    public void deleteCommentResponse(Long commentResponseId) {
        CommentResponse commentResponse = commentResponseRepository.findById(commentResponseId)
                .orElseThrow(() -> new NotFoundException("Comment Response"));

        Long profileId = currentUser.getProfileId();
        boolean isAdmin = currentUser.hasRole(UserRole.ROLE_ADMIN);
        boolean isPostWriter = Objects.equals(commentResponse.getComment().getPost().getProfile().getId(), profileId);
        boolean isCommentWriter = Objects.equals(commentResponse.getComment().getProfile().getId(), profileId);
        boolean isResponseWriter = Objects.equals(commentResponse.getProfile().getId(), profileId);

        if (isAdmin || isPostWriter || isCommentWriter || isResponseWriter) {
            commentResponseRepository.delete(commentResponse);
            return;
        }

        CommunityMember communityMember = communityMemberRepository.
                findByProfileIdAndCommunityId(profileId, commentResponse.getComment().getPost().getCommunity().getId()).
                orElseThrow(NotParticipatedException::new);

        if (communityMember.getRole().equals(CommunityMember.Role.USER))
            throw new NotAllowedException();

        commentResponseRepository.delete(commentResponse);
    }
}
