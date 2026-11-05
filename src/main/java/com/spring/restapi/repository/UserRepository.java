package com.spring.restapi.repository;

import com.spring.restapi.dto.UserDto;
import com.spring.restapi.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository

public class UserRepository {
    private final List<User> userData;


    public UserRepository(){
        User user1 = new User(UUID.randomUUID(),"admin", "admin01","Administrator");
        User user2 = new User(UUID.randomUUID(),"hr", "hr01","hr");
        User user3 = new User(UUID.randomUUID(),"design", "d001","Designer");
        User user4 = new User(UUID.randomUUID(),"Developer", "de002","Engineer");
        User user5 = new User(UUID.randomUUID(),"Bank-End", "be001","Back-End");
        userData = new ArrayList<>();
        userData.add(user1);
        userData.add(user2);
        userData.add(user3);
        userData.add(user4);
        userData.add(user5);
    }

    public List<User> select(){
        return userData;
    }

    // add new User
    public User addUser(User user){

        User newUser = new User(
                UUID.randomUUID(),
                user.name(),
                user.password(),
                user.fullName()
        );
        // add new user to list
        userData.add(newUser);

        return newUser;
    }


}
