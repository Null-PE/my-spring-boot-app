package com.x.s.myspringbootapp.service;

import com.x.s.myspringbootapp.entity.User;

import java.util.Optional;

public interface UserService {

    Optional<User> getUserById(Long id);

    Optional<User> getUserByUserName(String userName);

    User createUser(User user);

    User updateUser(User user);

    void deleteUser(Long id);

}
