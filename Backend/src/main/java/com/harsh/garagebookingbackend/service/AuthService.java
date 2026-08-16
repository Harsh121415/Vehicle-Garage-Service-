package com.harsh.garagebookingbackend.service;

import com.harsh.garagebookingbackend.dto.request.LoginRequest;
import com.harsh.garagebookingbackend.dto.request.RegisterRequest;
import com.harsh.garagebookingbackend.dto.response.ApiResponse;
import com.harsh.garagebookingbackend.dto.response.AuthResponse;
import com.harsh.garagebookingbackend.dto.response.UserResponse;
import com.harsh.garagebookingbackend.model.User;
import com.harsh.garagebookingbackend.repository.UserRepository;


import com.harsh.garagebookingbackend.utils.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;
    private final JwtUtil jwtUtil;


    public ApiResponse register(RegisterRequest request) {

        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(encoder.encode(request.getPassword()));
        user.setPhone(request.getPhone());
        user.setRole(User.Role.valueOf(request.getRole()));

        User saved = userRepository.save(user);

        UserResponse response = UserResponse.builder()
                .id(saved.getId())
                .name(saved.getName())
                .email(saved.getEmail())
                .phone(saved.getPhone())
                .role(saved.getRole().name())
                .build();

        return new ApiResponse("Registered Successfully", true, response);
    }


    public ApiResponse login(LoginRequest request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!encoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid Password");
        }


        String token = jwtUtil.generateToken(user.getEmail());

        UserResponse userResponse = UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .phone(user.getPhone())
                .role(user.getRole().name())
                .build();

        AuthResponse authResponse = new AuthResponse(token, userResponse);

        return new ApiResponse("Login Successful", true, authResponse);
    }
}