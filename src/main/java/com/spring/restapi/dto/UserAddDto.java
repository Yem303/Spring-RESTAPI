package com.spring.restapi.dto;

public record UserAddDto(
        String name,
        String password,
        String fullName
) {
}
