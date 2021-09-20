package com.codel.api;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApiApplicationTests {

    @Test
    void contextLoads() {
        String a = "{\"reqType\":0,\"perception\": {\"inputText\": {\"text\": \"";
        String b = "\"}},\"userInfo\": {\"apiKey\": \"";
        String c = "\",\"userId\": \"";
        String d = "\"}\r\n" + "}";
        String string = a + "Word" + b + "key" + c + "userid" + d;
        System.out.println(string);
    }

}
