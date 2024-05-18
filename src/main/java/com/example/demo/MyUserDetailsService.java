package com.example.demo;

import com.example.demo.entities.CustomUser;
import com.example.demo.repositories.CustomUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private CustomUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<CustomUser> user = userRepository.findByName(username);

        return user.map(MyUserDetails::new).orElseThrow(() -> new UsernameNotFoundException(username));
    }
}
