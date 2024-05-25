package com.example.demo;


import com.example.demo.entities.CustomUser;
import com.example.demo.entities.Role;
import com.example.demo.repositories.RoleRepository;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegistrationController {
    @Autowired
    private UserService userService;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@RequestParam String name,
                               @RequestParam String email,
                               @RequestParam String password) {
        CustomUser user = new CustomUser();
        user.setName(name);
        user.setPassword(passwordEncoder.encode(password));
        Role newRole = roleRepository.findByName("USER");
        user.setRole(newRole);
        user.setEmail(email);
        userService.saveUser(user);

//        role.save(userRole);
        return "redirect:/login";
    }
}
