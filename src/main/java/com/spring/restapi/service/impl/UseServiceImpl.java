package com.spring.restapi.service.impl;

import com.spring.restapi.dto.UserAddDto;
import com.spring.restapi.dto.UserDto;
import com.spring.restapi.dto.UserUpdateDto;
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
    // UpdateById
    @Override
    public UserDto updateById(UUID id, UserUpdateDto userUpdateDto) {
        User updateUser = userRepository.select()
                .stream()
                .filter(user -> user.id().equals(id))
                .findFirst()
                .map(user -> new User(
                        // Add new user data for update
                        user.id(),
                        userUpdateDto.name(),
                        userUpdateDto.password(),
                        userUpdateDto.fullName()
                ))
                .orElseThrow(() -> new RuntimeException("Not found"));
                // remove old user
                userRepository.select().removeIf(user -> user.id().equals(id));
                // Add to list of user that updated
                userRepository.select().add(updateUser);
                // Convert into userDto
                return new UserDto(updateUser.id(), updateUser.fullName());
    }
    // DeleteById
    @Override
    public void deleteById(UUID id) {
        boolean isDeleted = userRepository.select().stream()
                // if not true no delete user
                .anyMatch(user -> user.id().equals(id));
        if(isDeleted)
            // if true delete
          userRepository.select().removeIf(user -> user.id().equals(id));
        else
            throw new RuntimeException("User not found.");
    }

    // Get by id

    @Override
    public UserDto getById(UUID id) {
        return userRepository.select().stream()
                .filter(user -> user.id().equals(id)).findFirst()
                .map(user -> new UserDto(user.id(), user.fullName())).orElseThrow();
    }

    // Get all and filter search
    @Override
    public List<UserDto> getUsers(String keyword) {
        return userRepository.select()
                .stream()
                .filter(user -> user.fullName()
                        .toLowerCase()
                        .contains(keyword.toLowerCase()))
                .map(user -> new UserDto(user.id(), user.fullName()))
                .toList();
    }

    // Add new user
    @Override
    public UserDto addNew(UserAddDto userAddDto) {
        User user = new User(
                UUID.randomUUID(),
                userAddDto.name(),
                userAddDto.password(),
                userAddDto.fullName()
        );
        // add new user to list
        userRepository.select().add(user);
        // Convert into userDto
        return new UserDto(user.id(), user.fullName());
    }



}
