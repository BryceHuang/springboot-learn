package com.example.controller;

import com.example.Util.RedisUtil;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RedisTestController {
    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private UserService userService;

    @PostMapping("/rest/test-redis-cache")
    public Object testRedisCache() {
        return userService.getUserById(3);

    }

    @PostMapping("/rest/test-delete-user")
    public void testDeleteUser() {
        userService.deleteUser(2);
    }


    @PostMapping("/rest/test-redis")
    public Object testRedis() {
        redisUtil.set("test",100L);
        return redisUtil.get("test");
    }
}
