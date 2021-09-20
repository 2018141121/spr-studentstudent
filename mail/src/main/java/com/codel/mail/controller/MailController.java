package com.codel.mail.controller;

import com.codel.mail.sersvice.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * 邮件控制器
 *
 * @author codel
 * @date 2021/09/23
 */
@RestController
@RequestMapping("/mail")
public class MailController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private MailService mailService;

    /**
     * 发送邮件
     *
     * @param userName 用户名
     *                 把接收人的信息传递进去
     * @return {@link String}
     */
    @GetMapping("/send")
    public String sendMail(@RequestParam(value = "userName") String userName) {
        mailService.sendSimpleMail(userName);
        return "success";
    }

    /**
     * 发送附件电子邮件
     *
     * @param username 用户名
     * @return {@link String}
     */
    @GetMapping("/sendEmail/{username}")
    public String sendEmail(@PathVariable("username") String username) {
        mailService.sendMail(username);
        return "附件文件发送成功";
    }

    @GetMapping("/test")
    public String findById() {
        return restTemplate.getForObject("http://localhost:8087/test", String.class);
    }
}

