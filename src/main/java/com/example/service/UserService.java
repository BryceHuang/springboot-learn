package com.example.service;

import com.example.entity.UserBean;

import java.util.Optional;


public interface UserService {
    void addUser(UserBean user);

    Optional<UserBean> getUserById(Integer userId);
}
