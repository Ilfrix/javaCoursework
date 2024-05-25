package com.example.demo.services;

import com.example.demo.entities.CustomUser;
import com.example.demo.entities.Role;
import com.example.demo.repositories.CustomUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomUserService {
    private CustomUserRepository customUserRepository;

    public Long createUser(Long id, String name, Role role, String email) {
        CustomUser customUser = new CustomUser(id, name, role, email);
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
    public void updateUser(Long id, String name, Role role) {
        var optionalUser = customUserRepository.findById(id);
        var user = optionalUser.get();
        user.setName(name);
        user.setRole(role);
        customUserRepository.save(user);
    }

}