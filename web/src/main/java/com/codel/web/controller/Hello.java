package com.codel.web.controller;

import com.codel.web.pojo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
//注释类
@Api(tags = "控制类")
public class Hello {

    @CrossOrigin //解除跨域问题
    @GetMapping("/hello")
    @ApiOperation("hello测试")
    public String hello1() {

        return "hello word!";
    }

    @ApiOperation("得到用户的类")  //注释方法
    @PostMapping("/getUser")
    public User getUser(@RequestBody User user) {

        user.setName(user.getName());
        user.setPassword(user.getPassword());
        System.out.println(user);
        return user;
    }
}
