package com.gamerum.backend.adaptor.controller.user;

import com.gamerum.backend.adaptor.dto.response.ResponseData;
import com.gamerum.backend.adaptor.dto.user.profile.ProfileGetDTO;
import com.gamerum.backend.adaptor.dto.user.profile.ProfileUpdateDTO;
import com.gamerum.backend.adaptor.mapper.profile.ProfileMapper;
import com.gamerum.backend.external.persistence.elasticsearch.document.CommunityDocument;
import com.gamerum.backend.external.persistence.elasticsearch.document.PostDocument;
import com.gamerum.backend.usecase.service.profile.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/profiles")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @Autowired
    private ProfileMapper profileMapper;

    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @GetMapping("/{profileId}")
    public ResponseEntity<ResponseData<ProfileGetDTO>> getProfileById(@PathVariable Long profileId) throws IOException {
        return new ResponseEntity<>(
                new ResponseData<>(
                        true,
                        "Profile received",
                        profileMapper.profileToProfileGetDTO(profileService.getProfileById(profileId))),
                HttpStatus.OK);
    }

    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @PutMapping("/{profileId}")
    public ResponseEntity<ResponseData<ProfileGetDTO>> updateProfile(@RequestBody ProfileUpdateDTO profileUpdateDTO) throws IOException {
        return new ResponseEntity<>(
                new ResponseData<>(
                        true,
                        "Profile updated",
                        profileMapper.profileToProfileGetDTO(profileService.updateProfile(profileUpdateDTO))),
                HttpStatus.OK);
    }

    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @GetMapping("/{profileId}/communities")
    public ResponseEntity<ResponseData<List<CommunityDocument>>> getProfileCommunities(
            @PathVariable Long profileId,
            @RequestParam int page) throws IOException {
        return new ResponseEntity<>(
                new ResponseData<>(
                        true,
                        "Profile Communities received",
                        profileService.getCommunities(profileId, page)),
                HttpStatus.OK);
    }

    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @GetMapping("/{profileId}/posts")
    public ResponseEntity<ResponseData<List<PostDocument>>> getProfilePosts(
            @PathVariable Long profileId,
            @RequestParam int page) throws IOException {
        return new ResponseEntity<>(
                new ResponseData<>(
                        true,
                        "Profile Posts received",
                        profileService.getPosts(profileId, page)),
                HttpStatus.OK);
    }

}