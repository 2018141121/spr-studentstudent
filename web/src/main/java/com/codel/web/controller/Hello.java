package com.codel.web.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {

    @CrossOrigin //解除跨域问题
    @GetMapping("/hello")
    public String hello1() {

        return "hello word!";
    }
}
