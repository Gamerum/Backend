package com.gamerum.backend.adaptor.controller;

import com.gamerum.backend.external.persistence.entity.Community;
import com.gamerum.backend.external.persistence.entity.CommunityMember;
import com.gamerum.backend.usecase.service.CommunityMemberService;
import com.gamerum.backend.usecase.service.CommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/communities")
public class CommunityController {

    @Autowired
    private CommunityService communityService;

    @Autowired
    private CommunityMemberService communityMemberService;

    // Get a community by ID
    @GetMapping("/{id}")
    public ResponseEntity<Community> getCommunity(@PathVariable Long id) {
        return new ResponseEntity<>(communityService.getCommunity(id), HttpStatus.OK) ;
    }

    // Get all communities
    @GetMapping
    public ResponseEntity<List<Community>> getAllCommunities() {
        return new ResponseEntity<>(communityService.getAllCommunities(),HttpStatus.OK);
    }

    // Create a new community
    @PostMapping
    public ResponseEntity<Community> createCommunity(@RequestBody Community community) {
        return new ResponseEntity<>(communityService.createCommunity(community),HttpStatus.CREATED);
    }

    // Update an existing community
    @PutMapping("/{id}")
    public ResponseEntity<Community> updateCommunity(@PathVariable Long id, @RequestBody Community community) {
        community.setId(id);
        return new ResponseEntity<>(communityService.updateCommunity(community),HttpStatus.OK);
    }

    // Delete a community
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCommunity(@PathVariable Long id) {
        communityService.deleteCommunity(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Get a community by title
    @GetMapping("/title/{title}")
    public ResponseEntity<Community> getCommunityByTitle(@PathVariable String title) {
        return new ResponseEntity<>(communityService.getCommunityByTitle(title),HttpStatus.OK);
    }

    // Get community tags by ID
    @GetMapping("/{id}/tags")
    public ResponseEntity<String> getCommunityTags(@PathVariable Long id) {
        return new ResponseEntity<>(communityService.getCommunityTags(id),HttpStatus.OK);
    }

    // Create a community member
    @PostMapping("/members")
    public ResponseEntity<CommunityMember> createCommunityMember(@RequestBody CommunityMember communityMember) {
        return new ResponseEntity<>(communityMemberService.createCommunityMember(communityMember),HttpStatus.CREATED);
    }

    // Get a community member by ID
    @GetMapping("/members/{id}")
    public ResponseEntity<CommunityMember> getCommunityMember(@PathVariable Long id) {
        return new ResponseEntity<>(communityMemberService.getCommunityMember(id),HttpStatus.OK);
    }

    // Get all community members
    @GetMapping("/members")
    public ResponseEntity<List<CommunityMember>> getAllCommunityMembers() {
        return new ResponseEntity<>(communityMemberService.getCommunityMembers(),HttpStatus.OK);
    }

    // Delete a community member
    @DeleteMapping("/members/{id}")
    public ResponseEntity<Void> deleteCommunityMember(@PathVariable Long id) {
        communityMemberService.deleteCommunityMember(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Get community members by community ID
    @GetMapping("/{communityId}/members")
    public ResponseEntity<List<CommunityMember>> getCommunityMembersByCommunity(@PathVariable Long communityId) {
        return new ResponseEntity<>(communityMemberService.getCommunityMembersByCommunity(communityId),HttpStatus.OK);
    }

    // Get community members by profile ID
    @GetMapping("/profiles/{profileId}/members")
    public ResponseEntity<List<CommunityMember>> getCommunityMembersByProfile(@PathVariable Long profileId) {
        return new ResponseEntity<>(communityMemberService.getCommunityMembersByProfile(profileId),HttpStatus.OK);
    }
}
