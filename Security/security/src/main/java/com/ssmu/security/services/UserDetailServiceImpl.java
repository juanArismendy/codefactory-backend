package com.ssmu.security.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ssmu.security.model.AppUser;
import com.ssmu.security.repositories.UserRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    // @Override
    // public UserDetails loadUserByUsername(String username) {
    // AppUser user = userRepository.findByUsername(username);
    // System.out.println("user: " + user.toString());
    // if (user == null) {
    // throw new UsernameNotFoundException(username);
    // }
    // return new
    // org.springframework.security.core.userdetails.User(user.getUsername(),
    // user.getPassword(), new ArrayList<>());
    // }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser user = userRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException(username);
        }

        Collection<? extends GrantedAuthority> roles = user.getRoles().stream()
                .map(role -> new GrantedAuthority() {
                    private static final long serialVersionUID = 1L;

                    @Override
                    public String getAuthority() {
                        return role.getName().name();
                    }
                }).toList();

        return new org.springframework.security.core.userdetails.User(user.getUsername(),
                user.getPassword(), roles);
        // return org.springframework.security.core.userdetails.User
        // .withUsername(username)
        // .password(user.getPassword())
        // .roles(user.getRoles().toArray(new String[0]))
        // .build();
    }

}