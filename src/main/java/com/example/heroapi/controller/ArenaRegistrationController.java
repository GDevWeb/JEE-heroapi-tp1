package com.example.heroapi.controller;

import com.example.heroapi.service.ArenaRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/arena")
public class ArenaRegistrationController {

    private final ArenaRegistrationService registrationService;

    @Autowired
    public ArenaRegistrationController(ArenaRegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping("/register")
    public void registerToArena() {
        registrationService.register();
    }
}
