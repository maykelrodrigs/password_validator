package io.github.maykelrodrigs.iti.controller;

import io.github.maykelrodrigs.iti.service.PasswordService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/password")
public class PasswordController {

    private final PasswordService passwordService;

    public PasswordController(PasswordService passwordService) {
        this.passwordService = passwordService;
    }

    @GetMapping("/{password}/validate")
    public boolean validate(@PathVariable String password) {
        return passwordService.validate(password);
    }

}



