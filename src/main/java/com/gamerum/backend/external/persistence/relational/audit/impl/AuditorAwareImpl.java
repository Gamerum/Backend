package com.gamerum.backend.external.persistence.relational.audit.impl;

import com.gamerum.backend.usecase.service.user.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<Long> {
    @Autowired
    private CurrentUser currentUser;

    @Override
    public Optional<Long> getCurrentAuditor() {
        return Optional.ofNullable(currentUser.getProfileId());
    }
}
