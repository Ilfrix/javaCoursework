package com.example.demo.services;

import com.example.demo.entities.CustomUser;
import com.example.demo.repositories.CustomUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomUserService {
    private CustomUserRepository customUserRepository;

    public Long createUser(Long id, String name, String role) {
        CustomUser customUser = new CustomUser(id, name, role);
        customUserRepository.save(customUser);
        return customUser.getId();
    }
    public CustomUser getUser(Long id) {
        var user = customUserRepository.findById(id);
        return user.get();
    }
    public void deleteUser(Long id) {
        customUserRepository.deleteById(id);
    }
    public void updateUser(Long id, String name, String role) {
        var optionalUser = customUserRepository.findById(id);
        var user = optionalUser.get();
        user.name = name;
        user.role = role;
        customUserRepository.save(user);
    }

}