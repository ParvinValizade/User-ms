package com.company.userms.service.impl;

import com.company.userms.dto.converter.UserToUserResponseConverter;
import com.company.userms.dto.request.CreateUserRequest;
import com.company.userms.dto.response.UserResponse;
import com.company.userms.enums.ErrorCodeEnum;
import com.company.userms.exception.UserAlreadyExistsException;
import com.company.userms.model.User;
import com.company.userms.repository.UserRepository;
import com.company.userms.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserToUserResponseConverter converter;


    @Override
    public UserResponse createUser(CreateUserRequest request){
        checkUserAlreadyExistOrNot(request.getPin());
        User user = User.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .pin(request.getPin())
                .build();


        return converter.convert(userRepository.save(user));
    }

    private void checkUserAlreadyExistOrNot(String pin){
        Optional<User> user = userRepository.findByPin(pin);
        user.ifPresent(user1 -> {
            throw new UserAlreadyExistsException(ErrorCodeEnum.USER_ALREADY_EXISTS);
        });
    }
}
