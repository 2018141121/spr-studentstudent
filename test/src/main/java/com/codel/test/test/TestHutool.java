package com.codel.test.test;

import cn.hutool.extra.mail.MailUtil;

public class TestHutool {


    public static void main(String[] args) {
        MailUtil.send("3189144168@qq.com", "测试", "邮件来自Hutool测试", false);
    }
}
