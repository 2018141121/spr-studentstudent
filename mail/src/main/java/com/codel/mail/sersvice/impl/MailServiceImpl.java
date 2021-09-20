package com.codel.mail.sersvice.impl;

import com.codel.mail.sersvice.MailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * 邮件服务impl
 * 需要先构建 SimpleMailMessage或 MimeMessage邮件信息类来填写邮件标题、邮件内容等信息，
 * 最后提交给JavaMailSenderImpl发送邮件，
 *
 * @author codel
 * @date 2021/09/23
 */
@Service
@Slf4j
public class MailServiceImpl implements MailService {
    //    JavaMailSender 实现  MailSender 拥有发送文件的功能
    @Autowired
    private JavaMailSender mailSender;
    @Value("${mail.from}")
    private String mailFrom;

    /**
     * 发送简单的邮件
     * mailFrom 是发件人，
     * mailTo 是收件人。
     * message.setSubject()设置邮件主题。
     * message.setText()设置邮件内容。
     * mailSender.send(message)是发送短信。
     *
     * @param mailTo 邮件
     */
    @Override
    public void sendSimpleMail(String mailTo) {
        //创建邮件  SimpleMailMessage是创建文件 包括内容，邮件消息，发件人，收件人……
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom(mailFrom);
        message.setTo(mailTo);
        message.setSubject("simple mail");
        message.setText("hello world");

        //发送邮件
        mailSender.send(message);
        log.info("邮件已经发送");
    }

    /**
     * 发送附件邮件
     * MimeMessage 比 SimpleMailMessage 功能更强大，可以发送附件，也可以将内容转成html 格式发送。
     * 所以一般实际使用的时候都使用MimeMessage。
     * 另外发送附件，还需要借助MimeMessageHelper 。
     * MimeMessageHelper是辅助MimeMessage的。
     *
     * @param mail 邮件
     */
    @Override
    public void sendMail(String mail) {
//
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = null;
        try {
            helper = new MimeMessageHelper(message, true);
            helper.setFrom(mailFrom);
            helper.setTo(mail);
            helper.setSubject("simple mail");
            helper.setText("hello world", true);
            FileSystemResource file = new FileSystemResource(new File("D:\\大四\\1.png"));
            String fileName = file.getFilename();
            assert fileName != null;
            helper.addAttachment(fileName, file);
            mailSender.send(message);
            log.info("附件邮件已经发送");
        } catch (MessagingException e) {
            log.error("{}", e);
        }
    }

    /**
     * 发送电子邮件模板
     *
     * @param to      收件人
     * @param subject 主题
     * @param content 内容
     */
    @Override
    public void sendTemplateEmail(String to, String subject, String content) {

        MimeMessage message = mailSender.createMimeMessage();
        try {
            //使用MimeMessageHelper帮助类并设置multpart多部件使用为true
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(mailFrom);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content, true);
            //发送邮件
            mailSender.send(message);

            System.out.println("模板邮件发送成功!");
        } catch (MessagingException e) {
            System.out.println("模板邮件发送失败");
            e.printStackTrace();
        }
    }

}


