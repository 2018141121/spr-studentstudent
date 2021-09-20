package com.codel.mybatis_plus.mybatis_plus.controller;


import com.codel.mybatis_plus.mybatis_plus.service.MyAsycService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AsyncController {
    @Autowired
    private MyAsycService myAsycService;

    @GetMapping("/sendmail")
    public String test() throws InterruptedException {
        long startTime = System.currentTimeMillis();
//        模拟发送邮件
        myAsycService.sendMSM();
        long endTime = System.currentTimeMillis();
        System.out.println("主线程耗时:" + (endTime - startTime));
        return "信息发送成功！";
    }


}
