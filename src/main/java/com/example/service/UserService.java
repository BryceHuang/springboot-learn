package com.example.service;

import com.example.entity.UserBean;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface UserService {
    void addUser(UserBean user);

    Optional<UserBean> getUserById(Integer userId);
}
