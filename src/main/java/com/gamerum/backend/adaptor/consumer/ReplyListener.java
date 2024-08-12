package com.gamerum.backend.adaptor.consumer;

import com.gamerum.backend.external.persistence.relational.entity.notification.content.CommentReplyNotificationContent;
import com.gamerum.backend.external.persistence.elasticsearch.document.DocumentIndex;
import com.gamerum.backend.external.persistence.elasticsearch.document.ReplyDocument;
import com.gamerum.backend.external.persistence.elasticsearch.repository.ElasticsearchRepository;
import com.gamerum.backend.external.persistence.relational.entity.notification.Notification;
import com.gamerum.backend.external.persistence.relational.entity.community.Reply;
import com.gamerum.backend.usecase.service.notification.NotificationService;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostRemove;
import org.springframework.context.annotation.Lazy;

import java.io.IOException;
import java.util.ArrayList;

public class ReplyListener {
    private final ElasticsearchRepository elasticsearchRepository;
    private final NotificationService notificationService;

    public ReplyListener(ElasticsearchRepository elasticsearchRepository, @Lazy NotificationService notificationService) {
        this.elasticsearchRepository = elasticsearchRepository;
        this.notificationService = notificationService;
    }

    @PostPersist
    public void handleAfterSave(Reply reply) throws IOException {
        elasticsearchRepository.save(ReplyDocument.builder()
                .id(reply.getId().toString())
                .likedByProfileIds(new ArrayList<>())
                .build());

        CommentReplyNotificationContent content = CommentReplyNotificationContent
                .builder()
                .replyId(reply.getId())
                .commentId(reply.getComment().getId())
                .postId(reply.getComment().getPost().getId())
                .replierId(reply.getProfile().getId())
                .replierNickname(reply.getProfile().getNickname())
                .build();

        Notification notification = Notification.builder()
                .type(Notification.Type.COMMENT_READ)
                .notifiedProfile(reply.getComment().getProfile())
                .notificationContent(content)
                .build();

        notificationService.sendAndSaveNotification(notification);
    }

    @PostRemove
    public void handleAfterUpdate(Reply reply) throws IOException {
        elasticsearchRepository.deleteById(reply.getId().toString(), DocumentIndex.REPLY);
    }
}
