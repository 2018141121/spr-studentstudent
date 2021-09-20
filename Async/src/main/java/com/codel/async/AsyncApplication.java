package com.codel.async;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableAsync //开启异步
@EnableScheduling   //启用定时调度
public class AsyncApplication {

    public static void main(String[] args) {
        SpringApplication.run(AsyncApplication.class, args);
    }

}
