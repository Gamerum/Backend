package com.gamerum.backend.usecase.service.community.post.impl;

import com.gamerum.backend.adaptor.dto.community.post.comment.reply.ReplyCreateDTO;
import com.gamerum.backend.adaptor.dto.community.post.comment.reply.ReplyUpdateDTO;
import com.gamerum.backend.external.persistence.relational.entity.Comment;
import com.gamerum.backend.external.persistence.relational.entity.Reply;
import com.gamerum.backend.external.persistence.relational.entity.CommunityMember;
import com.gamerum.backend.external.persistence.relational.repository.CommentRepository;
import com.gamerum.backend.external.persistence.relational.repository.ReplyRepository;
import com.gamerum.backend.external.persistence.relational.repository.CommunityMemberRepository;
import com.gamerum.backend.security.user.UserRole;
import com.gamerum.backend.usecase.exception.NotFoundException;
import com.gamerum.backend.usecase.exception.ParticipationException;
import com.gamerum.backend.usecase.exception.ForbiddenException;
import com.gamerum.backend.usecase.service.community.post.ReplyService;
import com.gamerum.backend.usecase.service.user.CurrentUser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReplyServiceImpl implements ReplyService {
    @Value("${page.reply.size}")
    private int replyPageSize;

    private final ReplyRepository replyRepository;
    private final CommentRepository commentRepository;
    private final CommunityMemberRepository communityMemberRepository;
    private final CurrentUser currentUser;

    public ReplyServiceImpl(ReplyRepository replyRepository, CommentRepository commentRepository, CommunityMemberRepository communityMemberRepository, CurrentUser currentUser) {
        this.replyRepository = replyRepository;
        this.commentRepository = commentRepository;
        this.communityMemberRepository = communityMemberRepository;
        this.currentUser = currentUser;
    }

    @Override
    public Reply createReply(Long commentId, ReplyCreateDTO replyCreateDTO) {
        Comment comment = commentRepository.findById(commentId).
                orElseThrow(() -> new NotFoundException(Comment.class));

        Long communityId = comment.getPost().getCommunity().getId();
        Long writerProfileId = currentUser.getProfileId();

        CommunityMember writer = communityMemberRepository
                .findByProfileIdAndCommunityId(writerProfileId, communityId)
                .orElseThrow(() -> new ParticipationException(false));

        return replyRepository.save(Reply.builder()
                .text(replyCreateDTO.getText())
                .comment(comment)
                .profile(writer.getProfile())
                .build());
    }

    @Override
    public List<Reply> getReplies(Long commentId, int page) {
        return replyRepository.findByCommentId(commentId, PageRequest.of(page, replyPageSize));
    }

    @Override
    public Reply updateReply(Long replyId, ReplyUpdateDTO replyUpdateDTO) {
        Reply reply = replyRepository
                .findById(replyId)
                .orElseThrow(() -> new NotFoundException(Reply.class));

        if (!reply.getProfile().getId().equals(currentUser.getProfileId()))
            throw new ForbiddenException();

        reply.setText(replyUpdateDTO.getText());
        return replyRepository.save(reply);
    }

    @Override
    public void deleteReply(Long replyId) {
        Reply reply = replyRepository.findById(replyId)
                .orElseThrow(() -> new NotFoundException(Reply.class));

        Long profileId = currentUser.getProfileId();
        boolean isAdmin = currentUser.hasRole(UserRole.ROLE_ADMIN);
        boolean isPostWriter = reply.getComment().getPost().getProfile().getId().equals(profileId);
        boolean isCommentWriter = reply.getComment().getProfile().getId().equals(profileId);
        boolean isReplyWriter = reply.getProfile().getId().equals(profileId);

        if (!isAdmin && !isPostWriter && !isCommentWriter && !isReplyWriter) {
            CommunityMember communityMember = communityMemberRepository.
                    findByProfileIdAndCommunityId(profileId, reply.getComment().getPost().getCommunity().getId()).
                    orElseThrow(() -> new ParticipationException(false));

            if (communityMember.getRole().equals(CommunityMember.Role.USER)) throw new ForbiddenException();
        }
        replyRepository.delete(reply);
    }
}
