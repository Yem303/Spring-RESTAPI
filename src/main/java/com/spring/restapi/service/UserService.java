package com.spring.restapi.service;

import com.spring.restapi.dto.UserDto;
import com.spring.restapi.model.User;

import java.util.List;

public interface UserService {

    // get all users
    List<UserDto> getUsers(String keyword);

    // Create new user
    UserDto createUser(UserDto userDto);

}
