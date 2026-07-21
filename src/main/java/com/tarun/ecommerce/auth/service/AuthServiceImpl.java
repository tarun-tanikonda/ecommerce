package com.tarun.ecommerce.auth.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.tarun.ecommerce.auth.dto.request.LoginRequest;
import com.tarun.ecommerce.auth.dto.response.LoginResponse;
import com.tarun.ecommerce.auth.mapper.LoginMapper;
import com.tarun.ecommerce.common.exception.InvalidCredentialsException;
import com.tarun.ecommerce.common.exception.UserNotFoundException;
import com.tarun.ecommerce.user.entity.User;
import com.tarun.ecommerce.user.repository.UserRepository;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
    User user = userRepository.findByEmail(loginRequest.getEmail())
            .orElseThrow(() -> new UserNotFoundException("Invalid email or password"));
    if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
        throw new InvalidCredentialsException("Invalid email or password");
    }
    return LoginMapper.toLoginResponse(user);
}

}
