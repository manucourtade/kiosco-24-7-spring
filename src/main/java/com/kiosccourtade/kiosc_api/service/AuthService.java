package com.kiosccourtade.kiosc_api.service;

import com.kiosccourtade.kiosc_api.model.User;
import com.kiosccourtade.kiosc_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public String register(String username, String password) {
        String password2 = passwordEncoder.encode(password);
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isEmpty()) {
            String token = jwtService.generateToken(username);
            User user1 = new User();
            user1.setUsername(username);
            user1.setPassword(password2);
            user1.setRole("ROLE_ADMIN");
            userRepository.save(user1);
            return token;
        }
        return null;

    }

    public String login (String username, String password) {
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isEmpty()) return null;
        if (passwordEncoder.matches(password, user.get().getPassword()))
            return jwtService.generateToken(user.get().getUsername());
        return null;
    }
}
