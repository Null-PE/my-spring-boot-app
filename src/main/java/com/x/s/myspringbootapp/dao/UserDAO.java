package com.x.s.myspringbootapp.dao;


import com.x.s.myspringbootapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDAO extends JpaRepository<User, Long> {

    Optional<User> findByUserName(String userName);
}
