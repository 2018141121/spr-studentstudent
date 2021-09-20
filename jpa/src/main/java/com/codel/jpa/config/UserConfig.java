package com.codel.jpa.config;

import com.codel.jpa.pojo.User;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


@Configuration  //说明是配置类 ==bean.xml
@EnableConfigurationProperties(User.class)
public class UserConfig {

//    @Bean //注册为bean 就是将组件名字为user001的组件放进容器里面
//    public User user001() {
//        return new User(2, "codeL", "123");
//    }
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
