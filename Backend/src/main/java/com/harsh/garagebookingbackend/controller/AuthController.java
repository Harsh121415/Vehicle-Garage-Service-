package com.harsh.garagebookingbackend.controller;

import com.harsh.garagebookingbackend.dto.request.LoginRequest;
import com.harsh.garagebookingbackend.dto.request.RegisterRequest;
import com.harsh.garagebookingbackend.dto.response.ApiResponse;
import com.harsh.garagebookingbackend.service.AuthService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@CrossOrigin("*")
public class AuthController {

    private final AuthService authService;


    @PostMapping("/register")
    public ApiResponse register(@RequestBody RegisterRequest request) {
        return authService.register(request);
    }

    @PostMapping("/login")
    public ApiResponse login(@RequestBody LoginRequest request) {
        return authService.login(request);
    }
}