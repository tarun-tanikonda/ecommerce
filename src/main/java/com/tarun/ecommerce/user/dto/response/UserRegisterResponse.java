package com.tarun.ecommerce.user.dto.response;

import com.tarun.ecommerce.user.enums.Role;
import com.tarun.ecommerce.user.enums.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRegisterResponse {

    private Long userId;

    private String firstName;

    private String lastName;

    private String email;

    private String phoneNumber;

    private Role role;

    private UserStatus status;

    private Boolean emailVerified;
}