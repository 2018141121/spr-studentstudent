package com.example.demotest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class test {
    @GetMapping("test")
    public String tests() {
        return "hello word!";
    }
}
