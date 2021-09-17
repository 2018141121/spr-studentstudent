package com.codel.jpa.controller;


import com.codel.jpa.mapper.UserRepository;
import com.codel.jpa.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    public UserRepository userRepository;
    @Autowired
    User user;

    //    使用迭代器获取所有用户
    @GetMapping("/finduser")
    public Iterable<User> findUser() {
        Iterable<User> all = userRepository.findAll();
        return all;
    }

    @GetMapping("/findById")
    public Optional<User> findById(int id) {
//        id为唯一，防止为空的
        Optional<User> byId = userRepository.findById(id);
        return byId;
    }

    @GetMapping("/user")
    public User getUser() {
        return user;
    }
}
