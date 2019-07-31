package com.example.user.service;

import java.util.Date;
import java.util.Set;

import com.example.common.jwt.JwtTokenProvider;
import com.example.user.model.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtServices {

    private JwtTokenProvider jwtTokenProvider = new JwtTokenProvider();

    @Autowired
    private CustomeUserDetailService userDetailService;

    public String createToken(String username, Set<Role> set) {
        Claims claims = Jwts.claims().setSubject(username);
        claims.put("roles", set);

        Date now = new Date();
        Date validity = new Date(now.getTime() + jwtTokenProvider.getValidityInMilliseconds());
        return Jwts.builder().setClaims(claims).setIssuedAt(now).setExpiration(validity)
                .signWith(SignatureAlgorithm.HS256, jwtTokenProvider.getSecretKey()).compact();
    }

    public Authentication getAuthentication(String token) {
        String username = jwtTokenProvider.getUsername(token);

        System.out.println(username);
        UserDetails userDetails = this.userDetailService.loadUserByUsername(jwtTokenProvider.getUsername(token));
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    public JwtTokenProvider getJwtTokenProvider() {
        return this.jwtTokenProvider;
    }
}