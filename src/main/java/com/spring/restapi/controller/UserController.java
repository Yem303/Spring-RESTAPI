package com.spring.restapi.controller;

import com.spring.restapi.dto.UserAddDto;
import com.spring.restapi.dto.UserDto;
import com.spring.restapi.dto.UserUpdateDto;
import com.spring.restapi.model.User;
import com.spring.restapi.repository.UserRepository;
import com.spring.restapi.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public UserDto updateById(
            @PathVariable UUID id,
            @RequestBody UserUpdateDto userUpdateDto
    ) {
        return userService.updateById(id, userUpdateDto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id){
        userService.deleteById(id);
    }

    @GetMapping("/{id}")
    public UserDto getById(@PathVariable UUID id){
        return userService.getById(id);
    }

    @GetMapping
    public List<UserDto> getUsers(@RequestParam(required = false, defaultValue = "") String keyword){
       return userService.getUsers(keyword);
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public UserDto getNewUser(@RequestBody UserAddDto userAddDto){
        return userService.addNew(userAddDto);
    }
}
