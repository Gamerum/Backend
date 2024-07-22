package com.gamerum.backend.adaptor.controller;

import com.gamerum.backend.external.persistence.relational.entity.Profile;
import com.gamerum.backend.usecase.service.profile.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/profiles")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    // Get a profile by ID
    @GetMapping("/{id}")
    public ResponseEntity<Profile> getProfileById(@PathVariable Long id) {
       return new ResponseEntity<>(profileService.getProfileById(id), HttpStatus.OK);
    }

    // Create a new profile
    @PostMapping
    public ResponseEntity<Profile> createProfile(@RequestBody Profile profile) {
        return new ResponseEntity<>(profileService.createProfile(profile),HttpStatus.CREATED);
    }

    // Update an existing profile
    @PutMapping("/{id}")
    public ResponseEntity<Profile> updateProfile(@PathVariable Long id, @RequestBody Profile profile) {
        profile.setId(id);
        return new ResponseEntity<>(profileService.updateProfile(profile), HttpStatus.OK);
    }

    // Delete a profile by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProfile(@PathVariable Long id) {
        profileService.deleteProfile(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Get a profile by nickname
    @GetMapping("/nickname/{nickname}")
    public ResponseEntity<Profile> getProfileByNickname(@PathVariable String nickname) {
        return new ResponseEntity<>(profileService.getProfileNickName(nickname),HttpStatus.OK);
    }
}
