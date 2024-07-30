package com.gamerum.backend.usecase.service.user;

import com.gamerum.backend.security.jwt.JwtUtil;
import com.gamerum.backend.security.user.UserRole;
import com.gamerum.backend.usecase.exception.NotAllowedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
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

    public Long getProfileId(){
        if (TOKEN == null) throw new NotAllowedException();
        return jwtUtil.getClaimFromToken(TOKEN, claims -> claims.get("profileId", Long.class));
    }

    public boolean hasRole(UserRole role) {
        if (TOKEN == null) throw new NotAllowedException();
        List<GrantedAuthority> authorities = jwtUtil.getGrantedAuthorities(TOKEN);
        return authorities.stream().anyMatch(a -> a.getAuthority().equals(role.toString()));
    }
}
