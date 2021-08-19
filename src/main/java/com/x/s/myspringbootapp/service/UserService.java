package com.x.s.myspringbootapp.service;

import com.x.s.myspringbootapp.utils.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<User> getAllUsers() {
        return jdbcTemplate.query("SELECT * FROM User", new BeanPropertyRowMapper<>(User.class));
    }

    public int addUser(User user) {
        return jdbcTemplate.update("INSERT INTO User (name) SELECT * FROM (SELECT ?) AS tmp WHERE NOT EXISTS(SELECT 1 FROM User WHERE id = ? and name = ?)", user.getName(), user.getId(), user.getName());
    }


}
