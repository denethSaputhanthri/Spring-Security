package edu.icet.controller;

import edu.icet.model.User;
import edu.icet.service.MyUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public")
public class RegistationController {

    @Autowired
    private MyUserDetailService service;

    @GetMapping("/test")
    public String testEndpoint() {
        return "This is a test endpoint for registration.";
    }

    @PostMapping("/register")
    public void registerUser(@RequestBody User user) {
        service.saveUser(user);
    }
}
