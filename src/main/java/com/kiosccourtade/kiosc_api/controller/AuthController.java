package com.kiosccourtade.kiosc_api.controller;

import com.kiosccourtade.kiosc_api.dto.LoginDTO;
import com.kiosccourtade.kiosc_api.dto.RegisterDTO;
import com.kiosccourtade.kiosc_api.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")     // → POST /auth/login
    public ResponseEntity<String> log(@Valid @RequestBody LoginDTO dto) {
        String user = authService.login(dto.username(), dto.password());
        return ResponseEntity.status(200).body(user);
    }

    @PostMapping("/register")  // → POST /auth/register
    public ResponseEntity<String> register(@Valid @RequestBody RegisterDTO dto) {
        String user = authService.register(dto.username(), dto.password(), dto.role());
        return ResponseEntity.status(201).body(user);
    }
}
