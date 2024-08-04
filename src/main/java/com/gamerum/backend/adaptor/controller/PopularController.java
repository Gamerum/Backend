package com.gamerum.backend.adaptor.controller;

import com.gamerum.backend.external.persistence.elasticsearch.document.CommunityDocument;
import com.gamerum.backend.external.persistence.elasticsearch.document.GameDocument;
import com.gamerum.backend.external.persistence.elasticsearch.document.PostDocument;
import com.gamerum.backend.usecase.service.popular.PopularService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/popular")
public class PopularController {
    private final PopularService popularService;

    public PopularController(PopularService popularService) {
        this.popularService = popularService;
    }

    @GetMapping("/communities")
    public ResponseEntity<List<CommunityDocument>> getPopularCommunities() throws IOException {
        return new ResponseEntity<>(popularService.getPopularCommunities(), HttpStatus.OK);
    }

    @GetMapping("/posts")
    public ResponseEntity<List<PostDocument>> getPopularPosts(@RequestParam(defaultValue = "0") Integer page) throws IOException {
        return new ResponseEntity<>(popularService.getPopularPosts(page), HttpStatus.OK);
    }

    @GetMapping("/communities/{communityId}/posts")
    public ResponseEntity<List<PostDocument>> getCommunityPopularPosts(@PathVariable String communityId, @RequestParam(defaultValue = "0") Integer page) throws IOException {
        return new ResponseEntity<>(popularService.getCommunityPopularPosts(communityId, page), HttpStatus.OK);
    }

    @GetMapping("/games")
    public ResponseEntity<List<GameDocument>> getPopularGames() throws IOException {
        return new ResponseEntity<>(popularService.getPopularGames(), HttpStatus.OK);
    }
}
