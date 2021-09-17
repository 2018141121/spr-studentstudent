package com.codel.mybatis.controller;

import com.codel.mybatis.mapper.UserMapper;
import com.codel.mybatis.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {
    @Autowired
    UserMapper userMapper;

    @GetMapping("/test")
    public String test() {
        return "hello codeL";
    }

    @GetMapping("/getuser")
    public List<User> getUser() {
        return userMapper.getUsers();
    }

    @GetMapping("/getname")
    public List<User> getUserByName() {
        return userMapper.getUserByName("c");
    }

    @GetMapping("/getUserById/{id}")
    public User getUserById( @PathVariable("id") Integer id) {
        return userMapper.getUserById(id);
    }
}
