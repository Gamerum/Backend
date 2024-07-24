package com.gamerum.backend.adaptor.controller;

import com.gamerum.backend.external.persistence.relational.entity.Community;
import com.gamerum.backend.external.persistence.relational.entity.CommunityMember;
import com.gamerum.backend.usecase.service.community.CommunityMemberService;
import com.gamerum.backend.usecase.service.community.CommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
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
    @GetMapping("/public/{id}")
    public ResponseEntity<Community> getCommunity(@PathVariable Long communityId) {
        return new ResponseEntity<>(communityService.getCommunity(communityId), HttpStatus.OK) ;
    }

    // Get all communities
    @GetMapping("/public")
    public ResponseEntity<List<Community>> getAllCommunities() {
        return new ResponseEntity<>(communityService.getAllCommunities(),HttpStatus.OK);
    }

    // Create a new community
    @Secured({"ROLE_USER","ROLE_ADMIN"})
    @PostMapping
    public ResponseEntity<Community> createCommunity(@RequestBody Community community) {
        return new ResponseEntity<>(communityService.createCommunity(community),HttpStatus.CREATED);
    }

    // Update an existing community
    @Secured({"ROLE_USER","ROLE_ADMIN"})
    @PutMapping("/{id}")
    public ResponseEntity<Community> updateCommunity(@PathVariable Long communityId, @RequestBody Community community) {
        community.setId(communityId);
        return new ResponseEntity<>(communityService.updateCommunity(community),HttpStatus.OK);
    }

    // Delete a community
    @Secured({"ROLE_USER","ROLE_ADMIN"})
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCommunity(@PathVariable Long communityId) {
        communityService.deleteCommunity(communityId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Get a community by title
    @GetMapping("/public/title/{title}")
    public ResponseEntity<Community> getCommunityByTitle(@PathVariable String title) {
        return new ResponseEntity<>(communityService.getCommunityByTitle(title),HttpStatus.OK);
    }

    // Get community tags by ID
    @GetMapping("/public/{id}/tags")
    public ResponseEntity<String> getCommunityTags(@PathVariable Long communityId) {
        return new ResponseEntity<>(communityService.getCommunityTags(communityId),HttpStatus.OK);
    }

    // Create a community member
    @PostMapping("/members")
    @Secured({"ROLE_USER","ROLE_ADMIN"})
    public ResponseEntity<CommunityMember> createCommunityMember(@RequestBody CommunityMember communityMember) {
        return new ResponseEntity<>(communityMemberService.createCommunityMember(communityMember),HttpStatus.CREATED);
    }

    // Get a community member by ID
    @GetMapping("/public/members/{id}")
    public ResponseEntity<CommunityMember> getCommunityMember(@PathVariable Long communityMemberid) {
        return new ResponseEntity<>(communityMemberService.getCommunityMember(communityMemberid),HttpStatus.OK);
    }

    // Get all community members
    @GetMapping("/public/members")
    public ResponseEntity<List<CommunityMember>> getAllCommunityMembers() {
        return new ResponseEntity<>(communityMemberService.getCommunityMembers(),HttpStatus.OK);
    }

    // Delete a community member
    @Secured({"ROLE_USER","ROLE_ADMIN"})
    @DeleteMapping("/members/{id}")
    public ResponseEntity<Void> deleteCommunityMember(@PathVariable Long communityMemberid) {
        communityMemberService.deleteCommunityMember(communityMemberid);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Get community members by community ID
    @GetMapping("/public/{communityId}/members")
    public ResponseEntity<List<CommunityMember>> getCommunityMembersByCommunity(@PathVariable Long communityId) {
        return new ResponseEntity<>(communityMemberService.getCommunityMembersByCommunity(communityId),HttpStatus.OK);
    }

    // Get community members by profile ID
    @GetMapping("/public/profiles/{profileId}/members")
    public ResponseEntity<List<CommunityMember>> getCommunityMembersByProfile(@PathVariable Long profileId) {
        return new ResponseEntity<>(communityMemberService.getCommunityMembersByProfile(profileId),HttpStatus.OK);
    }

    @GetMapping("/public/populars")
    public ResponseEntity<List<Community>> getTop5PopularCommunities() {
        return new ResponseEntity<>(communityService.getTop5PopularCommunities(), HttpStatus.OK);
    }
}
