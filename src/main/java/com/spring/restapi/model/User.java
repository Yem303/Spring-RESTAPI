package com.spring.restapi.model;

import java.util.UUID;

public record User(
        UUID id,
        String name,
        String password,
        String fullName
) {

}
