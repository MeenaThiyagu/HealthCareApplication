package com.pharmaceutical.app.HealthcareApplication.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pharmaceutical.app.HealthcareApplication.AuthenticationBean;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping
public class BasicAuthController {

    @GetMapping(path = "/basicauth")
    public AuthenticationBean basicauth() {
        return new AuthenticationBean("You are authenticated");
    }
}
