package com.example.demo.controllers;

import com.example.demo.entities.CustomUser;
import com.example.demo.repositories.CustomUserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class CustomUserController {
    private final CustomUserRepository customUserRepository;

    public CustomUserController(CustomUserRepository customUserRepository) {
        this.customUserRepository = customUserRepository;
    }
    @GetMapping("/")
    public List<CustomUser> getUsers() {
        return customUserRepository.findAll();
    }
    @PostMapping("/")
    public CustomUser createUser(@RequestBody CustomUser newCustomUser) {
        System.out.println("OUTPUT" + newCustomUser.id + newCustomUser.name + newCustomUser.getRole().getName());
        return customUserRepository.save(newCustomUser);
    }
    @DeleteMapping("/{id}")
    public CustomUser deleteUser(@PathVariable Long id) {
        try{
            var customUser = customUserRepository.findById(id);
            CustomUser user = customUser.get();
            customUserRepository.deleteById(id);

            return user;
        } catch (Error e) {
            return null;
        }
    }

}
