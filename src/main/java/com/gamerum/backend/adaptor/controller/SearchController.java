package com.gamerum.backend.adaptor.controller;

import com.gamerum.backend.adaptor.dto.search.CommunitySearchFilter;
import com.gamerum.backend.adaptor.dto.search.GameSearchFilter;
import com.gamerum.backend.adaptor.dto.search.PostSearchFilter;
import com.gamerum.backend.adaptor.dto.search.SearchFilter;
import com.gamerum.backend.external.persistence.elasticsearch.document.CommunityDocument;
import com.gamerum.backend.external.persistence.elasticsearch.document.GameDocument;
import com.gamerum.backend.external.persistence.elasticsearch.document.PostDocument;
import com.gamerum.backend.external.persistence.elasticsearch.document.ProfileDocument;
import com.gamerum.backend.usecase.service.search.SearchService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/search")
public class SearchController {
    private final SearchService searchService;

    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @PostMapping("/games")
    public ResponseEntity<List<GameDocument>> searchGamesWithName(@RequestBody GameSearchFilter filter) throws IOException {
        return new ResponseEntity<>(searchService.searchGame(filter), HttpStatus.OK);
    }

    @PostMapping("/communities")
    public ResponseEntity<List<CommunityDocument>> searchCommunities(@RequestBody CommunitySearchFilter filter) throws IOException {
        return new ResponseEntity<>(searchService.searchCommunity(filter), HttpStatus.OK);
    }

    @PostMapping("/profiles")
    public ResponseEntity<List<ProfileDocument>> searchProfiles(@RequestBody SearchFilter filter) throws IOException {
        return new ResponseEntity<>(searchService.searchProfile(filter), HttpStatus.OK);
    }

    @GetMapping("/posts")
    public ResponseEntity<List<PostDocument>> searchPosts(@RequestBody PostSearchFilter filter) throws IOException {
        return new ResponseEntity<>(searchService.searchPost(filter), HttpStatus.OK);
    }
}
