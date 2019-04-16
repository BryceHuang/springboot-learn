package com.example.controller;

import com.example.Util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisTestController {
    @Autowired
    private RedisUtil redisUtil;

    @PostMapping("/rest/test-redis")
    public Object testRedis() {
        redisUtil.set("test",100L);
        return redisUtil.get("test");
    }
}
