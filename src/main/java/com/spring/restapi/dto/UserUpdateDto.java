package com.spring.restapi.dto;

public record UserUpdateDto(
        String name,
        String password,
        String fullName
) {
}
