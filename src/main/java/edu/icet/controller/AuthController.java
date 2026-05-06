package edu.icet.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("secure")
public class AuthController {

    @GetMapping("user")
    public String sayHelloUser(){
        return "Hello, this is a secured endpoint for users!";
    }

    @GetMapping("customer")
    @PreAuthorize("hasAnyRole('MANAGER','ADMIN','SUPER_ADMIN')")
    public String sayHelloCustom(){
        return "Hello, this is a secured endpoint!";
    }

    @GetMapping("manager")
    @PreAuthorize("hasAnyRole('ADMIN','SUPER_ADMIN')")
    public String sayHelloManager(){
        return "Hello, this is a secured endpoint for managers!";
    }

    @GetMapping("admin")
    @PreAuthorize("hasAnyRole('ADMIN','SUPER_ADMIN')")
    public String sayHelloAdmin(){
        return "Hello, this is a secured endpoint for admins!";
    }

    @GetMapping("superadmin")
    @PreAuthorize("hasRole('SUPER_ADMIN')")
    public String sayHelloSuperAdmin(){
        return "Hello, this is a secured endpoint for super admins!";
    }
}
