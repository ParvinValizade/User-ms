package com.company.userms.service;

import com.company.userms.dto.request.CreateUserRequest;
import com.company.userms.dto.response.UserResponse;


public interface UserService {
    UserResponse createUser(CreateUserRequest request);
}
