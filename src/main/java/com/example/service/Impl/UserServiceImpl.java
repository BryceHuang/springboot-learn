package com.example.service.Impl;

import com.example.entity.UserBean;
import com.example.repository.UserRepository;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public void addUser(UserBean user) {
        userRepository.save(user);
    }

    @Override
    @Transactional
    public Optional<UserBean> getUserById(Integer userId) {
        return userRepository.findById(userId);
    }
}
