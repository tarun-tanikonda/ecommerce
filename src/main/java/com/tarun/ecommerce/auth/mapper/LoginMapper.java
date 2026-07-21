package com.tarun.ecommerce.auth.mapper;

import com.tarun.ecommerce.auth.dto.request.LoginRequest;
import com.tarun.ecommerce.auth.dto.response.LoginResponse;
import com.tarun.ecommerce.user.entity.User;

public class LoginMapper {

    private LoginMapper() {
    }

    public static User toEntity(LoginRequest loginRequest) {
        if (loginRequest == null) {
            return null;
        }

        User user = new User();
        user.setEmail(loginRequest.getEmail());
        user.setPassword(loginRequest.getPassword());

        return user;
    }

    public static LoginResponse toLoginResponse(User user) {
        if (user == null) {
            return null;
        }

        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setUserId(user.getUserId());
        loginResponse.setFirstName(user.getFirstName());
        loginResponse.setLastName(user.getLastName());
        loginResponse.setEmail(user.getEmail());
        loginResponse.setRole(user.getRole().name());

        return loginResponse;
    }

}
