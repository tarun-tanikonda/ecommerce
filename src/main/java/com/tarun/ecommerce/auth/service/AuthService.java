package com.tarun.ecommerce.auth.service;

import com.tarun.ecommerce.auth.dto.request.LoginRequest;
import com.tarun.ecommerce.auth.dto.response.LoginResponse;

public interface AuthService {

    LoginResponse login(LoginRequest loginRequest);

}
