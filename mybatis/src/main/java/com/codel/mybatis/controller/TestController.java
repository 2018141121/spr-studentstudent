package com.codel.mybatis.controller;

import com.codel.mybatis.mapper.UserMapper;
import com.codel.mybatis.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public User getUserById(@PathVariable("id") Integer id) {
        return userMapper.getUserById(id);
    }

    @GetMapping("/delUser")
    public String deleteUserById(int id, Model model) {
        int i = userMapper.deleteById(id);
        if (i > 0) {
            model.addAttribute("msg", "success");
            return "success";
        }
        return "false";


    }

    @PostMapping("/insertUser")
    public String insertUser(@RequestBody User user) {
        int i = userMapper.insertUser(user);
        if (i > 0) {
            return "success";
        }
        return "false";
    }

    @PostMapping("/updateUser")
    public String updateUser(@RequestBody User user) {
        int i = userMapper.updateUser(user);
        if (i > 0) {
            return "success";
        }
        return "false";
    }
}
