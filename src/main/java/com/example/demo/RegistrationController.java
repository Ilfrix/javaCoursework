package com.example.demo;


import com.example.demo.entities.CustomUser;
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
    private PasswordEncoder passwordEncoder;

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@RequestParam String userName,
                               @RequestParam String role,
                               @RequestParam String password) {
        CustomUser user = new CustomUser();
        user.setName(userName);
        user.setRole(role);
        user.setPassword(passwordEncoder.encode(password));
        userService.saveUser(user);
        return "redirect:/login";
    }
}
