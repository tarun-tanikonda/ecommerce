package com.tarun.ecommerce.user.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.tarun.ecommerce.common.exception.EmailAlreadyExistsException;
import com.tarun.ecommerce.common.exception.UserNotFoundException;
import com.tarun.ecommerce.user.dto.request.UserRegisterRequest;
import com.tarun.ecommerce.user.dto.response.UserRegisterResponse;
import com.tarun.ecommerce.user.entity.User;
import com.tarun.ecommerce.user.enums.Role;
import com.tarun.ecommerce.user.enums.UserStatus;
import com.tarun.ecommerce.user.mapper.UserMapper;
import com.tarun.ecommerce.user.repository.UserRepository;
import com.tarun.ecommerce.user.service.UserService;


@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserRegisterResponse registerUser(UserRegisterRequest userRegisterRequest) {
        if(userRepository.existsByEmail(userRegisterRequest.getEmail())) {
            throw new EmailAlreadyExistsException("Email already exists.");
        }
        User user = UserMapper.toEntity(userRegisterRequest);
        user.setRole(Role.CUSTOMER);
        user.setStatus(UserStatus.ACTIVE);
        user.setEmailVerified(false);
        User savedUser = userRepository.save(user);
        return UserMapper.toResponse(savedUser);
    }

    @Override
    public UserRegisterResponse getUserById(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found with ID : " + userId));
        return UserMapper.toResponse(user);
    }

    @Override
    public List<UserRegisterResponse> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(UserMapper::toResponse).collect(Collectors.toList());
    }
    
}
