package com.codel.mail;


import com.codel.mail.sersvice.impl.MailServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@SpringBootTest
class MailApplicationTests {
    /**
     * 测试发送模板邮件
     */
    @Autowired
    private MailServiceImpl mailService;
    @Autowired
    private TemplateEngine templateEngine;

    @Test
    public void sendTemplateEmail() {
        String to = "codel1115@qq.com";
        String subject = "【模板邮件】标题";

        //使用模板定制邮件正文内容
        Context context = new Context();
        context.setVariable("username", "codeL");
        context.setVariable("code", "489");

        //使用TemplateEngline设置要处理的模板 页面
        String emailTemplate = templateEngine.process("test", context);

        //发送模板邮件
        mailService.sendTemplateEmail(to, subject, emailTemplate);
    }

    @Test
    void contextLoads() {
    }

}
