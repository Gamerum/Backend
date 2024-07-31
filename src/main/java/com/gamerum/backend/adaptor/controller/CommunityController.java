package com.gamerum.backend.adaptor.controller;

import com.gamerum.backend.adaptor.dto.community.CommunityCreateDTO;
import com.gamerum.backend.adaptor.dto.community.CommunityGetDTO;
import com.gamerum.backend.adaptor.dto.community.CommunityUpdateDTO;
import com.gamerum.backend.adaptor.dto.community.member.CommunityMemberCreateDTO;
import com.gamerum.backend.adaptor.dto.community.member.CommunityMemberGetDTO;
import com.gamerum.backend.adaptor.dto.response.Response;
import com.gamerum.backend.adaptor.dto.response.ResponseData;
import com.gamerum.backend.adaptor.mapper.community.CommunityMapper;
import com.gamerum.backend.adaptor.mapper.community.CommunityMemberMapper;
import com.gamerum.backend.usecase.service.community.CommunityMemberService;
import com.gamerum.backend.usecase.service.community.CommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/communities")
public class CommunityController {

    @Autowired
    private CommunityService communityService;

    @Autowired
    private CommunityMemberService communityMemberService;

    @Autowired
    private CommunityMapper communityMapper;


    // Get a community by ID
    @GetMapping("/{communityId}")
    public ResponseEntity<ResponseData<CommunityGetDTO>> getCommunity(@PathVariable Long communityId) throws IOException {
        return new ResponseEntity<>(new ResponseData<>(
                true,
                "Community received",
                communityMapper.communityToCommunityGetDTO(
                        communityService.getCommunity(communityId))),
                HttpStatus.OK);
    }

    // Create a new community
    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @PostMapping
    public ResponseEntity<ResponseData<CommunityGetDTO>> createCommunity(@RequestBody CommunityCreateDTO community) throws IOException {
        return new ResponseEntity<>(new ResponseData<>(
                true,
                "Community Created",
                communityMapper.communityToCommunityGetDTO(
                        communityService.createCommunity(community))),
                HttpStatus.CREATED);
    }

    // Update an existing community
    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @PutMapping("/{communityId}")
    public ResponseEntity<ResponseData<CommunityGetDTO>> updateCommunity(
            @PathVariable Long communityId,
            @RequestBody CommunityUpdateDTO communityUpdateDTO) throws IOException {
        return new ResponseEntity<>(new ResponseData<>(
                true,
                "Community updated",
                communityMapper.communityToCommunityGetDTO(
                        communityService.updateCommunity(communityId, communityUpdateDTO))),
                HttpStatus.OK);
    }

    // Delete a community
    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @DeleteMapping("/{communityId}")
    public ResponseEntity<Response> deleteCommunity(
            @PathVariable Long communityId) {
        communityService.deleteCommunity(communityId);
        return new ResponseEntity<>(new Response(
                true,
                "Community deleted."),
                HttpStatus.NO_CONTENT);
    }

    // Create a community member
    @PostMapping("/{communityId}/members")
    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    public ResponseEntity<ResponseData<CommunityMemberGetDTO>> createCommunityMember(
            @PathVariable Long communityId,
            @RequestBody CommunityMemberCreateDTO communityMemberCreateDTO) {
        return new ResponseEntity<>(new ResponseData<>(
                true,
                "Member added",
                CommunityMemberMapper.INSTANCE.communityMemberToCommunityMemberGetDTO(
                        communityMemberService.createCommunityMember(communityId, communityMemberCreateDTO))),
                HttpStatus.CREATED);
    }

    // Get all community members
    @GetMapping("/{communityId}/members")
    public ResponseEntity<ResponseData<List<CommunityMemberGetDTO>>> getAllCommunityMembers(
            @PathVariable Long communityId,
            @RequestParam(required = false) int page,
            @RequestParam int size) {
        return new ResponseEntity<>(new ResponseData<>(
                true,
                "Members received.",
                CommunityMemberMapper.INSTANCE.communityMembersToCommunityMemberGetDTOs(
                        communityMemberService.getCommunityMembers(communityId, page, size))),
                HttpStatus.OK);
    }

    // Delete a community member
    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @DeleteMapping("/{communityId}/members")
    public ResponseEntity<Response> deleteCommunityMember(
            @PathVariable Long communityId,
            @RequestParam Long profileId) {
        communityMemberService.deleteCommunityMember(communityId, profileId);
        return new ResponseEntity<>(new Response(
                true,
                "Member deleted."),
                HttpStatus.NO_CONTENT);
    }
}
