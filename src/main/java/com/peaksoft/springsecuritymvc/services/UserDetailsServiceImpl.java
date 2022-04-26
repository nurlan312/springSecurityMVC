package com.peaksoft.springsecuritymvc.services;

import com.peaksoft.springsecuritymvc.models.securityModels.User;
import com.peaksoft.springsecuritymvc.models.securityModels.UserImpl;
import com.peaksoft.springsecuritymvc.reposiroties.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user =  repository.getUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Could not find user");
        }
        return new UserImpl(user);
    }
}
