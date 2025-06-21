package com.example.echs.service;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if ("user".equals(username)) {
            return new User("user", "userpass", Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")));
        } else if ("doctor".equals(username)) {
            return new User("doctor", "doctorpass", Collections.singletonList(new SimpleGrantedAuthority("ROLE_DOCTOR")));
        } else {
            throw new UsernameNotFoundException("User not found: " + username);
        }
    }
}