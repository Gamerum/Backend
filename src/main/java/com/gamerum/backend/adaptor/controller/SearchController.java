package com.gamerum.backend.adaptor.controller;

import com.gamerum.backend.adaptor.dto.response.ResponseData;
import com.gamerum.backend.adaptor.dto.search.GameSearchFilter;
import com.gamerum.backend.external.persistence.elasticsearch.document.GameDocument;
import com.gamerum.backend.usecase.service.search.SearchService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/search")
@AllArgsConstructor
public class SearchController {
    private final SearchService searchService;

    @PostMapping("/games_name")
    public ResponseEntity<ResponseData<Page<GameDocument>>> searchGamesWithName(@RequestBody GameSearchFilter filter) {
        return new ResponseEntity<>(new ResponseData<>(
                true,
                "Games received",
                searchService.searchGame(filter)),
                HttpStatus.OK);
    }
//
//    @GetMapping("/games_genre")
//    public ResponseEntity<String> searchGamesWithGenre(@RequestParam String searchTerm,
//                                                      @RequestParam int page,
//                                                      @RequestParam int size) {
//        return new ResponseEntity<>(searchService.searchGameWithGenres(searchTerm, page, size), HttpStatus.OK);
//    }
//
//    @GetMapping("/communities")
//    public ResponseEntity<List<CommunityDocument>> searchCommunities(@RequestParam String searchTerm,
//                                                                     @RequestParam int page,
//                                                                     @RequestParam int size) {
//        return new ResponseEntity<>(searchService.searchCommunity(searchTerm, page, size), HttpStatus.OK);
//    }
//
//    @GetMapping("/profiles")
//    public ResponseEntity<List<ProfileDocument>> searchProfiles(@RequestParam String searchTerm,
//                                                                   @RequestParam int page,
//                                                                   @RequestParam int size) {
//        return new ResponseEntity<>(searchService.searchProfile(searchTerm, page, size), HttpStatus.OK);
//    }
//
//    @GetMapping("/posts")
//    public ResponseEntity<List<PostDocument>> searchPosts(@RequestParam String searchTerm,
//                                                             @RequestParam int page,
//                                                             @RequestParam int size) {
//        return new ResponseEntity<>(searchService.searchPost(searchTerm, page, size), HttpStatus.OK);
//    }
}
