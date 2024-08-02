package com.gamerum.backend.adaptor.controller.community;

import com.gamerum.backend.adaptor.dto.community.member.CommunityMemberCreateDTO;
import com.gamerum.backend.adaptor.dto.community.member.CommunityMemberGetDTO;
import com.gamerum.backend.adaptor.dto.community.member.CommunityMemberUpdateDTO;
import com.gamerum.backend.adaptor.dto.response.Response;
import com.gamerum.backend.adaptor.dto.response.ResponseData;
import com.gamerum.backend.adaptor.mapper.community.CommunityMemberMapper;
import com.gamerum.backend.usecase.service.community.CommunityMemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/communities/{communityId}/members")
public class CommunityMemberController {
    private final CommunityMemberService communityMemberService;

    public CommunityMemberController(CommunityMemberService communityMemberService) {
        this.communityMemberService = communityMemberService;
    }

    @PostMapping
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

    @PutMapping
    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    public ResponseEntity<ResponseData<CommunityMemberGetDTO>> updateCommunityMember(
            @RequestBody CommunityMemberUpdateDTO communityMemberUpdateDTO) {
        return new ResponseEntity<>(new ResponseData<>(
                true,
                "Member updated.",
                CommunityMemberMapper.INSTANCE.communityMemberToCommunityMemberGetDTO(
                        communityMemberService.updateCommunityMember(communityMemberUpdateDTO))),
                HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<ResponseData<List<CommunityMemberGetDTO>>> getAllCommunityMembers(
            @PathVariable Long communityId,
            @RequestParam(defaultValue = "0") Integer page) {
        return new ResponseEntity<>(new ResponseData<>(
                true,
                "Members received.",
                CommunityMemberMapper.INSTANCE.communityMembersToCommunityMemberGetDTOs(
                        communityMemberService.getCommunityMembers(communityId, page))),
                HttpStatus.OK);
    }

    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @DeleteMapping
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
