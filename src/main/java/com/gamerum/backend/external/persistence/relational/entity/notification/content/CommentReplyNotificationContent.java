package com.gamerum.backend.external.persistence.relational.entity.notification.content;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CommentReplyNotificationContent implements NotificationContent {
    private Long postId;
    private Long commentId;
    private Long replyId;
    private Long replierId;
    private String replierNickname;
}
