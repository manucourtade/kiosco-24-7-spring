package com.kiosccourtade.kiosc_api.service;

import com.kiosccourtade.kiosc_api.exception.UnauthorizedException;
import com.kiosccourtade.kiosc_api.exception.UserAlreadyExistsException;
import com.kiosccourtade.kiosc_api.model.User;
import com.kiosccourtade.kiosc_api.repository.CategoryRepository;
import com.kiosccourtade.kiosc_api.repository.ProductRepository;
import com.kiosccourtade.kiosc_api.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class AuthServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private JwtService jwtService;

    @InjectMocks
    private AuthService authService;

    @Mock
    private PasswordEncoder passwordEncoder;


    @Test
    void shouldBeThrowExceptionIfUserExists() {
        when(userRepository.findByUsername("manu")).thenReturn(Optional.of(new User()));

        assertThrows(UserAlreadyExistsException.class, () ->
                authService.register("manu", "1234", "ROLE_USER"));
    }

    @Test
    void shouldReturnTokenIfUserDoesNotExist() {
        when(userRepository.findByUsername("manu")).thenReturn(Optional.empty());
        when(jwtService.generateToken("manu", "ROLE_USER")).thenReturn("token-falso-123");

        String result = authService.register("manu", "123456", "ROLE_USER");

        assertEquals("token-falso-123", result);
    }

    @Test
    void userNotLogin () {
        when(userRepository.findByUsername("manu")).thenReturn(Optional.empty());

        assertThrows(UnauthorizedException.class, () ->
                authService.login("manu", "1234"));
    }

    @Test
    void passwordFail() {
        User user = new User();
        user.setUsername("manu");
        user.setPassword("hashViejo123");

        when(userRepository.findByUsername("manu")).thenReturn(Optional.of(user));
        when(passwordEncoder.matches("1234", "hashViejo123")).thenReturn(false);

        assertThrows(UnauthorizedException.class, () ->
                authService.login("manu", "1234"));
    }

    @Test
    void GreatLog() {
        User user = new User();
        user.setUsername("manu");
        user.setPassword("hashViejo123");

        when(userRepository.findByUsername("manu")).thenReturn(Optional.of(user));
        when(passwordEncoder.matches("1234", "hashViejo123")).thenReturn(true);
        when(jwtService.generateToken("manu", user.getRole())).thenReturn("token-exitoso");

        String token = authService.login("manu", "1234");
        assertEquals( "token-exitoso", token);
    }
}
