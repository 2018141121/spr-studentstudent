package com.codel.mybatis_plus.mybatis_plus.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * 我的asyc服务
 *
 * @author codel
 * @date 2021/09/23
 */
@Service
public class MyAsycService {
    /**
     * 无返回值的异步调用
     * @throws InterruptedException
     */
    @Async//表明该方法是一个异步方法
    public void sendMSM() throws InterruptedException {
        System.out.println("调用短信方法....");
        long startTime = System.currentTimeMillis();
        Thread.sleep(5000);
        long endTime = System.currentTimeMillis();
        System.out.println("短信方法完成，耗时："+(endTime-startTime));
    }

}
