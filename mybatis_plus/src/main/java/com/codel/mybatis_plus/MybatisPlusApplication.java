package com.codel.mybatis_plus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

//@MapperScan("com.codel.mybatis_plus.mapper")
// 这个配置是启动就会去找这个地址的配置文件自动的装配进去容器里面
@SpringBootApplication
@EnableAsync  //开启异步
public class MybatisPlusApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisPlusApplication.class, args);
    }

}
