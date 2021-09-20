package com.condel.jwt;

import com.auth0.jwt.JWT;
import com.condel.jwt.mapper.GetTonken;
import com.condel.jwt.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
class JwtApplicationTests {
    @Autowired
    private GetTonken getTonken;

    @Test
    void contextLoads() {
        User user = new User();
        user.setId("12");
        user.setUsername("codeL");
        user.setPassword("12fdfd");
//        创建一个token
        String token = getTonken.getToken(user);
        System.out.println(token);

//        获取token里面的数据
        String s = JWT.decode(token).getAudience().get(0);

        System.out.println(s);


    }
    @Test
    void testJ(){
        Date date = new Date();

        DateFormat  dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String format = dateFormat.format(date);
        System.out.println(format);
    }

}
