package com.gamerum.backend.adaptor.controller.community;

import com.gamerum.backend.adaptor.dto.community.CommunityCreateDTO;
import com.gamerum.backend.adaptor.dto.community.CommunityGetDTO;
import com.gamerum.backend.adaptor.dto.community.CommunityUpdateDTO;
import com.gamerum.backend.adaptor.mapper.community.CommunityMapper;
import com.gamerum.backend.usecase.service.community.CommunityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/communities")
public class CommunityController {
    private final CommunityService communityService;
    private final CommunityMapper communityMapper;

    public CommunityController(CommunityService communityService, CommunityMapper communityMapper) {
        this.communityService = communityService;
        this.communityMapper = communityMapper;
    }

    @GetMapping("/{communityId}")
    public ResponseEntity<CommunityGetDTO> getCommunity(@PathVariable Long communityId) throws IOException {
        return new ResponseEntity<>(communityMapper.communityToCommunityGetDTO(communityService.getCommunity(communityId)), HttpStatus.OK);
    }

    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @PostMapping
    public ResponseEntity<CommunityGetDTO> createCommunity(@RequestBody CommunityCreateDTO community) throws IOException {
        return new ResponseEntity<>(communityMapper.communityToCommunityGetDTO(communityService.createCommunity(community)), HttpStatus.CREATED);
    }

    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @PutMapping("/{communityId}")
    public ResponseEntity<CommunityGetDTO> updateCommunity(@PathVariable Long communityId, @RequestBody CommunityUpdateDTO communityUpdateDTO) throws IOException {
        return new ResponseEntity<>(communityMapper.communityToCommunityGetDTO(communityService.updateCommunity(communityId, communityUpdateDTO)), HttpStatus.OK);
    }

    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @DeleteMapping("/{communityId}")
    public ResponseEntity deleteCommunity(@PathVariable Long communityId) {
        communityService.deleteCommunity(communityId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @PutMapping("/{communityId}/tags")
    public ResponseEntity<ResponseData<List<String>>> updateCommunityTags(
            @PathVariable Long communityId,
            @RequestBody CommunityUpdateTagsDTO communityUpdateTagsDTO) {
        return new ResponseEntity<>(new ResponseData<>(
                true,
                "Community updated",
                communityService.updateTagsToCommunity(communityId, communityUpdateTagsDTO)),
                HttpStatus.OK);
    }
}
