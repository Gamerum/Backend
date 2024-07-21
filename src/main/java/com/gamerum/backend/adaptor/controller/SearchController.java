package com.gamerum.backend.adaptor.controller;

import com.gamerum.backend.external.persistence.elasticsearch.document.CommunityDocument;
import com.gamerum.backend.usecase.exception.request.IGDBRequestException;
import com.gamerum.backend.usecase.service.search.SearchService;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.exceptions.UnirestException;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/search")
@AllArgsConstructor
public class SearchController {
    private final SearchService searchService;

    @GetMapping("/games")
    public ResponseEntity<String> searchGames(@RequestParam String name,
                                                @RequestParam int page,
                                                @RequestParam int size)
            throws UnirestException, IGDBRequestException {
        return new ResponseEntity<>(searchService.searchGame(name, page, size), HttpStatus.OK);
    }

    @GetMapping("/communities")
    public ResponseEntity<Page<CommunityDocument>> searchCommunities(@RequestParam String gameId,
                                                                     @RequestParam int page,
                                                                     @RequestParam int size){
        return new ResponseEntity<>(searchService.searchCommunity(gameId, page, size), HttpStatus.OK);
    }
}
