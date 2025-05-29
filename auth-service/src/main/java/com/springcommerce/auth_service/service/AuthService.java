package com.springcommerce.auth_service.service;

import com.netflix.discovery.converters.Auto;
import com.springcommerce.auth_service.dto.AuthResponse;
import com.springcommerce.auth_service.dto.LoginRequest;
import com.springcommerce.auth_service.dto.RegisterRequest;
import com.springcommerce.auth_service.entity.Role;
import com.springcommerce.auth_service.entity.User;
import com.springcommerce.auth_service.repository.UserRepository;
import com.springcommerce.auth_service.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private PasswordEncoder passwordEncoder;


    public AuthResponse register(RegisterRequest request) {
        String userName=request.getUserName();
        Optional<User> existing=userRepository.findByUserName(userName);

        if (existing.isPresent()){
            throw new RuntimeException("USerName already taken");
        }
        User user = User.builder()
                .userName(request.getUserName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
        userRepository.save(user);
        String token=jwtUtil.generateToken(user.getUserName(),user.getRole().name());
        return new AuthResponse("User registered successfully",token);
    }

    public AuthResponse login(LoginRequest request) {
        String userName = request.getUserName();
        String password = request.getPassword();
        User user = userRepository.findByUserName(userName)
                .orElseThrow(() -> new RuntimeException(("User not found")));

        if (!user.getPassword().equals(password)) {
            throw new RuntimeException("Invalid password");
        }
        String userRole=user.getRole().name();
        String token = jwtUtil.generateToken(user.getUserName(),userRole);
        return new AuthResponse("Login successful", token);
    }

    public boolean validateToken(String token) {
        return jwtUtil.validateToken(token);
    }
}