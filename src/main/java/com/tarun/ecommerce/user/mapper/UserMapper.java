package com.tarun.ecommerce.user.mapper;

import com.tarun.ecommerce.user.dto.request.UserRegisterRequest;
import com.tarun.ecommerce.user.dto.response.UserRegisterResponse;
import com.tarun.ecommerce.user.entity.User;

public final class UserMapper {

    // Private constructor to prevent instantiation
    private UserMapper() {
    }

    // Converts UserRegisterRequest to User Entity.
    public static User toEntity(UserRegisterRequest userRegisterRequest) {
        if (userRegisterRequest == null) {
            return null;
        }
        User user = new User();

        user.setFirstName(userRegisterRequest.getFirstName());
        user.setLastName(userRegisterRequest.getLastName());
        user.setEmail(userRegisterRequest.getEmail());
        user.setPassword(userRegisterRequest.getPassword()); 
        user.setPhoneNumber(userRegisterRequest.getPhoneNumber());

        return user;
    }


    // Converts User Entity to UserRegisterResponse.
    public static UserRegisterResponse toResponse(User user) {

        if (user == null) {
            return null;
        }

        UserRegisterResponse userRegisterResponse = new UserRegisterResponse();

        userRegisterResponse.setUserId(user.getUserId());
        userRegisterResponse.setFirstName(user.getFirstName());
        userRegisterResponse.setLastName(user.getLastName());
        userRegisterResponse.setEmail(user.getEmail());
        userRegisterResponse.setPhoneNumber(user.getPhoneNumber());
        userRegisterResponse.setRole(user.getRole());
        userRegisterResponse.setStatus(user.getStatus());
        userRegisterResponse.setEmailVerified(user.getEmailVerified());

        return userRegisterResponse;
    }
}