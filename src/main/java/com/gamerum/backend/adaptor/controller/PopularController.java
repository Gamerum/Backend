package com.gamerum.backend.adaptor.controller;

import com.gamerum.backend.adaptor.dto.response.ResponseData;
import com.gamerum.backend.external.persistence.elasticsearch.document.CommunityDocument;
import com.gamerum.backend.external.persistence.elasticsearch.document.PostDocument;
import com.gamerum.backend.usecase.service.popular.PopularService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/popular")
public class PopularController {
    @Autowired
    private PopularService popularService;

    @GetMapping("/communities")
    public ResponseEntity<ResponseData<List<CommunityDocument>>> getPopularCommunities() throws IOException {
        return new ResponseEntity<>(new ResponseData<>(
                true,
                "Popular communities sent.",
                popularService.getPopularCommunities()),
                HttpStatus.OK);
    }

    @GetMapping("/posts")
    public ResponseEntity<ResponseData<List<PostDocument>>> getPopularPosts() throws IOException {
        return new ResponseEntity<>(new ResponseData<>(
                true,
                "Popular posts sent.",
                popularService.getPopularPosts()),
                HttpStatus.OK);
    }

    @GetMapping("/communities/{communityId}/pots")
    public ResponseEntity<ResponseData<List<PostDocument>>> getCommunityPopularPosts(@PathVariable String communityId) throws IOException {
        return new ResponseEntity<>(new ResponseData<>(
                true,
                "Popular posts sent.",
                popularService.getCommunityPopularPosts(communityId)),
                HttpStatus.OK);
    }
}
