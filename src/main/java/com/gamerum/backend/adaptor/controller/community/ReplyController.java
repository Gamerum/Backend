package com.gamerum.backend.adaptor.controller.community;

import com.gamerum.backend.adaptor.dto.community.post.comment.reply.ReplyCreateDTO;
import com.gamerum.backend.adaptor.dto.community.post.comment.reply.ReplyGetDTO;
import com.gamerum.backend.adaptor.dto.community.post.comment.reply.ReplyUpdateDTO;
import com.gamerum.backend.adaptor.dto.response.Response;
import com.gamerum.backend.adaptor.dto.response.ResponseData;
import com.gamerum.backend.adaptor.mapper.community.ReplyMapper;
import com.gamerum.backend.usecase.service.community.post.ReplyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments/{commentId}/reply")
public class ReplyController {
    private final ReplyService replyService;

    public ReplyController(ReplyService replyService) {
        this.replyService = replyService;
    }

    @Secured({"ROLE_USER","ROLE_ADMIN"})
    @PostMapping
    public ResponseEntity<ResponseData<ReplyGetDTO>> createReply(
            @PathVariable Long commentId,
            @RequestBody ReplyCreateDTO replyCreateDTO) {
        return new ResponseEntity<>(new ResponseData<>(
                true,
                "Reply sent.",
                ReplyMapper.INSTANCE.replyToReplyGetDTO(
                        replyService.createReply(commentId, replyCreateDTO))),
                HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<ResponseData<List<ReplyGetDTO>>> getReplies(
            @PathVariable Long commentId,
            @RequestParam(required = false) int page,
            @RequestParam int size
    ) {
        return new ResponseEntity<>(new ResponseData<>(
                true,
                "Reply received.",
                ReplyMapper.INSTANCE.repliesToReplyGetDTOs(
                        replyService.getReplies(commentId, page, size))),
                HttpStatus.CREATED);
    }

    @Secured({"ROLE_USER","ROLE_ADMIN"})
    @PutMapping
    public ResponseEntity<ResponseData<ReplyGetDTO>> updateReply(
            @RequestBody ReplyUpdateDTO replyUpdateDTO) {
        return new ResponseEntity<>(new ResponseData<>(
                true,
                "Reply updated.",
                ReplyMapper.INSTANCE.replyToReplyGetDTO(
                        replyService.updateReply(replyUpdateDTO))),
                HttpStatus.OK);
    }

    @Secured({"ROLE_USER","ROLE_ADMIN"})
    @DeleteMapping
    public ResponseEntity<Response> deleteReply(@RequestParam Long commentId) {
        replyService.deleteReply(commentId);
        return new ResponseEntity<>(new Response(
                true,
                "Reply deleted."),
                HttpStatus.NO_CONTENT);
    }
}
