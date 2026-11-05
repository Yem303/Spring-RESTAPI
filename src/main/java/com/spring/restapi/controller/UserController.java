package com.spring.restapi.controller;

import com.spring.restapi.dto.UserDto;
import com.spring.restapi.model.User;
import com.spring.restapi.repository.UserRepository;
import com.spring.restapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;
    @GetMapping
    public List<UserDto> getUsers(@RequestParam(required = false, defaultValue = "") String keyword){
       return userService.getUsers(keyword);
    }

    @PostMapping
    public UserDto getNewUser(@RequestBody UserDto userDto){
        return userService.createUser(userDto);
    }
}
