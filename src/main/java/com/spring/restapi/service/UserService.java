package com.spring.restapi.service;

import com.spring.restapi.dto.UserAddDto;
import com.spring.restapi.dto.UserDto;
import com.spring.restapi.dto.UserUpdateDto;

import java.util.List;
import java.util.UUID;

public interface UserService {

    // get all users
    List<UserDto> getUsers(String keyword);

    // Create new user
    UserDto addNew(UserAddDto userAddDto);

    // Get userById
    UserDto getById(UUID id);

    // DeleteById
    void deleteById(UUID id);

    // Update Data by id
    UserDto updateById(UUID id, UserUpdateDto userUpdateDto);
}
