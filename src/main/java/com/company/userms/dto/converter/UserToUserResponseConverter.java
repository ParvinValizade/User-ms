package com.company.userms.dto.converter;

import com.company.userms.dto.response.UserResponse;
import com.company.userms.model.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserToUserResponseConverter {

    private final ModelMapper mapper;

    public UserToUserResponseConverter(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public UserResponse convert(User user){
        return mapper.map(user,UserResponse.class);
    }

    public List<UserResponse> convert(List<User> userList){
        return userList
                .stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }
}
