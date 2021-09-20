package com.codel.mybatis_plus.mybatis_plus.controller;

import com.codel.mybatis_plus.mybatis_plus.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class redisController {

    @Autowired
    private RedisTemplate redisTemplate;

    @PostMapping("/addredis")
    public String addRedis(@RequestBody User user) {
        System.out.println(user);
        try {
            redisTemplate.opsForValue().set("key",user);
            return "success";
        } catch (Exception e) {
            return "fail";
        }

    }
    @GetMapping("/getredis")
    public String getRedis(@RequestBody User user) {
        try {
            Object key = redisTemplate.opsForValue().get("key");
            System.out.println(key);
            return "success";
        } catch (Exception e) {
            return "fail";
        }

    }

}
