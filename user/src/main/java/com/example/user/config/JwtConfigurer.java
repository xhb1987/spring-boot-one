package com.example.user.config;

import com.example.common.jwt.JwtTokenProvider;

import com.example.user.service.JwtServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class JwtConfigurer extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        JwtTokenFilter customeFilter = new JwtTokenFilter();
        http.addFilterBefore(customeFilter, UsernamePasswordAuthenticationFilter.class);
    }
}