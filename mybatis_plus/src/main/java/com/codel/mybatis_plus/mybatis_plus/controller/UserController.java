package com.codel.mybatis_plus.mybatis_plus.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.codel.mybatis_plus.mybatis_plus.entity.User;
import com.codel.mybatis_plus.mybatis_plus.mapper.UserMapper;
import com.codel.mybatis_plus.mybatis_plus.service.impl.UserServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author codel
 * @since 2021-09-19
 */
@CrossOrigin
@RestController
@RequestMapping("/mybatis_plus/user")
public class UserController {
    @Autowired
    UserMapper userMapper;
    @Autowired
    UserServiceImpl userService;

    //对象解析为Jackson
    public String jacksonM(Object user) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(user);
    }

    //登录
    @PostMapping("/getUser")
    public String testUser(@RequestBody User user) throws JsonProcessingException {
        QueryWrapper<User> wrapper = new QueryWrapper<>();

        QueryWrapper<User> userQueryWrapper = wrapper.eq("name", user.getName()).eq("password", user.getPassword());
        User one = userService.getOne(userQueryWrapper);
        String s = jacksonM(one);
        System.out.println(one);
        if (one != null) {
            return s;
        }
        return "fail";
    }

    //注册
    @PostMapping("/setUser")
//  @RequestBody  是在请求体里面拿到数据
    public String setUser(@RequestBody User user) {
        boolean save = userService.save(user);
        if (save) {
            return "success";
        }
        return "fail";
    }


    @CrossOrigin
    @GetMapping("/allUser")
    public String allUsers() throws JsonProcessingException {
        List<User> list = userService.list();
        return jacksonM(list);
    }

    @GetMapping("/User")
    public String getUser1() throws JsonProcessingException {
        QueryWrapper<User> wrapper = new QueryWrapper<>();

        QueryWrapper<User> userQueryWrapper = wrapper.eq("name", "codel").eq("password", "codel");
        User one = userService.getOne(userQueryWrapper);
        return jacksonM(one);

    }
}
