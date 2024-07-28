package com.gamerum.backend.external.persistence.relational.audit.impl;

import com.gamerum.backend.security.jwt.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<Long> {
    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public Optional<Long> getCurrentAuditor() {
        return Optional.ofNullable(jwtUtil.getCurrentUserProfileId());
    }
}
