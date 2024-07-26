package com.gamerum.backend.adaptor.controller;

import com.gamerum.backend.adaptor.dto.response.ResponseData;
import com.gamerum.backend.adaptor.dto.search.CommunitySearchFilter;
import com.gamerum.backend.adaptor.dto.search.GameSearchFilter;
import com.gamerum.backend.external.persistence.elasticsearch.document.CommunityDocument;
import com.gamerum.backend.external.persistence.elasticsearch.document.GameDocument;
import com.gamerum.backend.usecase.service.search.SearchService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/search")
@AllArgsConstructor
public class SearchController {
    private final SearchService searchService;

    @PostMapping("/games")
    public ResponseEntity<ResponseData<List<GameDocument>>> searchGamesWithName(@RequestBody GameSearchFilter filter) throws IOException {
        return new ResponseEntity<>(new ResponseData<>(
                true,
                "Games received",
                searchService.searchGame(filter)),
                HttpStatus.OK);
    }

   @PostMapping("/communities")
    public ResponseEntity<ResponseData<List<CommunityDocument>>> searchCommunities(@RequestBody CommunitySearchFilter filter) throws IOException {
       return new ResponseEntity<>(new ResponseData<>(
               true,
               "Communities received",
               searchService.searchCommunity(filter)),
               HttpStatus.OK);
   }
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
