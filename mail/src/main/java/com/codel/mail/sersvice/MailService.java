package com.codel.mail.sersvice;

public interface MailService {
    void sendSimpleMail(String mail);
    void sendMail(String mail);
    void sendTemplateEmail(String to,String subject,String content);
}
