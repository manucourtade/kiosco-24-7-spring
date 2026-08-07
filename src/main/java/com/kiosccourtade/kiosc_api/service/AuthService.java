package com.kiosccourtade.kiosc_api.service;

import com.kiosccourtade.kiosc_api.exception.UnauthorizedException;
import com.kiosccourtade.kiosc_api.exception.UserAlreadyExistsException;
import com.kiosccourtade.kiosc_api.model.User;
import com.kiosccourtade.kiosc_api.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

    public String register(String username, String password, String role) {
        String password2 = passwordEncoder.encode(password);
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isEmpty()) {
            User user1 = new User();
            user1.setUsername(username);
            user1.setPassword(password2);
            user1.setRole(role);
            String token = jwtService.generateToken(username, role);
            userRepository.save(user1);
            return token;
        }
        throw new UserAlreadyExistsException();

    }

    public String login (String username, String password) {
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isEmpty()) throw new UnauthorizedException();
        if (passwordEncoder.matches(password, user.get().getPassword()))
            return jwtService.generateToken(user.get().getUsername(), user.get().getRole());
        throw new UnauthorizedException();
    }
}
