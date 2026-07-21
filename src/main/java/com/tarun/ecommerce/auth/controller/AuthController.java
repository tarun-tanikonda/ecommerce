package com.tarun.ecommerce.auth.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tarun.ecommerce.auth.dto.request.LoginRequest;
import com.tarun.ecommerce.auth.dto.response.LoginResponse;
import com.tarun.ecommerce.auth.service.AuthService;
import com.tarun.ecommerce.common.response.ApiResponse;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<LoginResponse>> login(@Valid @RequestBody LoginRequest loginRequest){
        LoginResponse response = authService.login(loginRequest);
        ApiResponse<LoginResponse> apiResponse = ApiResponse.<LoginResponse>builder()
            .success(true)
            .message("Login successful.")
            .data(response)
            .build();
        return ResponseEntity.ok(apiResponse);
    }

}
