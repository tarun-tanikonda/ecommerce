package com.tarun.ecommerce.user.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.tarun.ecommerce.user.dto.request.UserRegisterRequest;
import com.tarun.ecommerce.user.dto.response.UserRegisterResponse;

@Service
public interface UserService {

    UserRegisterResponse registerUser(UserRegisterRequest userRegisterRequest);

    UserRegisterResponse getUserById(Long userId);

    List<UserRegisterResponse> getAllUsers();

}
