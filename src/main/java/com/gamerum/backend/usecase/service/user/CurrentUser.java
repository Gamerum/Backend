package com.gamerum.backend.usecase.service.user;

import com.gamerum.backend.security.jwt.JwtUtil;
import com.gamerum.backend.security.user.UserRole;
import com.gamerum.backend.usecase.exception.ForbiddenException;
import com.gamerum.backend.usecase.exception.UnauthorizedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurrentUser {
    private static String TOKEN;

    @Autowired
    private JwtUtil jwtUtil;

    public static void setToken(String token) {
        TOKEN = token;
    }

    public boolean isAuthenticated() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication != null && authentication.isAuthenticated() && !authentication.getPrincipal().equals("anonymousUser");
    }

    public Long getUserId() {
        if (TOKEN == null) throw new UnauthorizedException();
        return jwtUtil.getUserIdFromToken(TOKEN);
    }

    public Long getProfileId() {
        if (TOKEN == null) throw new UnauthorizedException();
        return jwtUtil.getClaimFromToken(TOKEN, claims -> claims.get("profileId", Long.class));
    }

    public boolean hasRole(UserRole role) {
        if (TOKEN == null) throw new UnauthorizedException();
        List<GrantedAuthority> authorities = jwtUtil.getGrantedAuthorities(TOKEN);
        return authorities.stream().anyMatch(a -> a.getAuthority().equals(role.toString()));
    }
}
