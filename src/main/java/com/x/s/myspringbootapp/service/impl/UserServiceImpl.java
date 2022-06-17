package com.x.s.myspringbootapp.service.impl;

import com.x.s.myspringbootapp.dao.UserDAO;
import com.x.s.myspringbootapp.entity.User;
import com.x.s.myspringbootapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserDAO userDAO;

    @Override
    public Optional<User> getUserById(Long id) {
        return userDAO.findById(id);
    }

    @Override
    public Optional<User> getUserByUserName(String userName) {
        return userDAO.findByUserName(userName);
    }

    @Override
    public User createUser(User user) {
        return null;
    }

    @Override
    public User updateUser(User user) {
        return null;
    }

    @Override
    public void deleteUser(Long id) {

    }
}
