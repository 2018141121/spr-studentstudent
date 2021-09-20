package com.codel.test.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class test {
    @PostMapping("/test")
    public String test1(@RequestBody String id) {
        JSONObject jsonObject = JSONObject.parseObject(id);
        Object id1 = jsonObject.get("id");
        System.out.println(id1);
        return id;
    }
}
