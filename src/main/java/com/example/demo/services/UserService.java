package com.example.demo.services;

import com.example.demo.entities.CustomUser;
import com.example.demo.repositories.CustomUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserService implements UserDetailsService {
    @Autowired
    private CustomUserRepository customUserRepository;
    public CustomUser saveUser(CustomUser user) {
        return customUserRepository.save(user);
    }

    public Optional<CustomUser> findByUserName(String userName) {
        return customUserRepository.findByName(userName);
    }

    public void setCustomUserRepository(CustomUserRepository customUserRepository){
        this.customUserRepository = customUserRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<CustomUser> userOptional = customUserRepository.findByName(username);
        CustomUser user = userOptional.orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));

        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getName())
                .password(user.getPassword())
                .build();
    }
}
