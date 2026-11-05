package com.spring.restapi.service.impl;

import com.spring.restapi.dto.UserDto;
import com.spring.restapi.model.User;
import com.spring.restapi.repository.UserRepository;
import com.spring.restapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UseServiceImpl implements UserService {
    private final UserRepository userRepository;


    @Override
    public List<UserDto> getUsers(String keyword) {
        return userRepository.select()
                .stream()
                .filter(user -> user.fullName()
                        .toLowerCase()
                        .contains(keyword.toLowerCase()))
                .map(user -> new UserDto(user.id(), user.fullName())) // ប្តូរទៅតាម Constructor របស់ UserDto របស់អ្នក
                .toList();
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        // 1. Convert DTO to user
        User user = new User(userDto.id(),null, null,userDto.fullName());

        // 2. Save the user to the database
        User savedUser = userRepository.addUser(user);

        // 3. Convert the saved user back to DTO and return it
        return new UserDto(savedUser.id(), savedUser.fullName());
    }

}
