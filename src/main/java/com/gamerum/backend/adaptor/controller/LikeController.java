package com.gamerum.backend.adaptor.controller;

import com.gamerum.backend.external.persistence.elasticsearch.document.PostDocument;
import com.gamerum.backend.usecase.service.like.LikeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/like")
public class LikeController {
    private final LikeService likeService;

    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }

    @PatchMapping("/post/{postId}")
    public ResponseEntity<Boolean> postLike(@PathVariable String postId) throws IOException {
        return new ResponseEntity<>(likeService.updateLikeCount("post", postId, PostDocument.class), HttpStatus.OK);
    }

    @PatchMapping("/comment/{commentId}")
    public ResponseEntity<Boolean> commentLike(@PathVariable String commentId) throws IOException {
        return new ResponseEntity<>(likeService.updateLikeCount("comment", commentId, PostDocument.class), HttpStatus.OK);
    }

    @PatchMapping("/reply/{replyId}")
    public ResponseEntity<Boolean> replyLike(@PathVariable String replyId) throws IOException {
        return new ResponseEntity<>(likeService.updateLikeCount("reply", replyId, PostDocument.class), HttpStatus.OK);
    }
}
