package com.kiosccourtade.kiosc_api.controller;

import com.kiosccourtade.kiosc_api.dto.AuthDTO;
import com.kiosccourtade.kiosc_api.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")     // → POST /auth/login
    public ResponseEntity<String> log(@RequestBody AuthDTO dto) {
        String user = authService.login(dto.username(), dto.password());
        return ResponseEntity.status(200).body(user);
    }

    @PostMapping("/register")  // → POST /auth/register
    public ResponseEntity<String> register(@RequestBody AuthDTO dto) {
        String user = authService.register(dto.username(), dto.password());
        return ResponseEntity.status(201).body(user);
    }
}
