package com.tarun.ecommerce.user.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tarun.ecommerce.common.response.ApiResponse;
import com.tarun.ecommerce.user.dto.request.UserRegisterRequest;
import com.tarun.ecommerce.user.dto.response.UserRegisterResponse;
import com.tarun.ecommerce.user.service.UserService;

import org.springframework.web.bind.annotation.RequestBody;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<UserRegisterResponse>> registerUser(@Valid @RequestBody UserRegisterRequest userRegisterRequest) {
        UserRegisterResponse response = userService.registerUser(userRegisterRequest);
        ApiResponse<UserRegisterResponse> apiResponse = ApiResponse.<UserRegisterResponse>builder()
                    .success(true)
                    .message("User registered successfully.")
                    .data(response)
                    .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserRegisterResponse> getUserById(@PathVariable Long userId) {
        UserRegisterResponse response = userService.getUserById(userId);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserRegisterResponse>> getAllUsers() {
        List<UserRegisterResponse> responseList = userService.getAllUsers();
        return ResponseEntity.ok(responseList);
    }
    
}
