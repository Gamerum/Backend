package com.gamerum.backend.adaptor.consumer.eventListener.elasticsearch;

import com.gamerum.backend.external.persistence.elasticsearch.document.ProfileDocument;
import com.gamerum.backend.external.persistence.elasticsearch.repository.ProfileESRepository;
import com.gamerum.backend.external.persistence.relational.entity.Profile;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostUpdate;
import org.springframework.stereotype.Component;

@Component
public class ProfileSyncListener {
    private final ProfileESRepository profileESRepository;

    public ProfileSyncListener(ProfileESRepository profileESRepository) {
        this.profileESRepository = profileESRepository;
    }

    @PostPersist
    public void handleAfterSave(Profile profile) {
        ProfileDocument document = new ProfileDocument(profile);
        profileESRepository.save(document);
    }

    @PostUpdate
    public void handleAfterUpdate(Profile profile) {
        if (!profile.isActive()) {
            profileESRepository.deleteById(profile.getId().toString());
            return;
        }
        ProfileDocument document = new ProfileDocument(profile);
        profileESRepository.save(document);
    }
}
