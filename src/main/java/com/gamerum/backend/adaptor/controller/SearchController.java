package com.gamerum.backend.adaptor.controller;

import com.gamerum.backend.external.persistence.elasticsearch.document.CommunityDocument;
import com.gamerum.backend.external.persistence.elasticsearch.document.GameDocument;
import com.gamerum.backend.external.persistence.elasticsearch.document.PostDocument;
import com.gamerum.backend.external.persistence.elasticsearch.document.ProfileDocument;
import com.gamerum.backend.usecase.exception.request.IGDBRequestException;
import com.gamerum.backend.usecase.service.search.SearchService;
import com.mashape.unirest.http.exceptions.UnirestException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/search")
@AllArgsConstructor
public class SearchController {
    private final SearchService searchService;

    @GetMapping("/games_name")
    public ResponseEntity<List<GameDocument>> searchGamesWithName(@RequestParam String searchTerm,
                                                                  @RequestParam int page,
                                                                  @RequestParam int size) {
        return new ResponseEntity<>(searchService.searchGameWithName(searchTerm, page, size), HttpStatus.OK);
    }

    @GetMapping("/games_genre")
    public ResponseEntity<String> searchGamesWithGenre(@RequestParam String searchTerm,
                                                      @RequestParam int page,
                                                      @RequestParam int size)
            throws UnirestException, IGDBRequestException {
        return new ResponseEntity<>(searchService.searchGameWithGenres(searchTerm, page, size), HttpStatus.OK);
    }

    @GetMapping("/communities")
    public ResponseEntity<List<CommunityDocument>> searchCommunities(@RequestParam String searchTerm,
                                                                     @RequestParam int page,
                                                                     @RequestParam int size) {
        return new ResponseEntity<>(searchService.searchCommunity(searchTerm, page, size), HttpStatus.OK);
    }

    @GetMapping("/profiles")
    public ResponseEntity<List<ProfileDocument>> searchProfiles(@RequestParam String searchTerm,
                                                                   @RequestParam int page,
                                                                   @RequestParam int size) {
        return new ResponseEntity<>(searchService.searchProfile(searchTerm, page, size), HttpStatus.OK);
    }

    @GetMapping("/posts")
    public ResponseEntity<List<PostDocument>> searchPosts(@RequestParam String searchTerm,
                                                             @RequestParam int page,
                                                             @RequestParam int size) {
        return new ResponseEntity<>(searchService.searchPost(searchTerm, page, size), HttpStatus.OK);
    }
}
