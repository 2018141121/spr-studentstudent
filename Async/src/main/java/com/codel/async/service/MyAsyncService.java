package com.codel.async.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

/**
 * 我的异步服务
 *
 * @author codel
 * @date 2021/09/23
 */
@Service
public class MyAsyncService {
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

    /**
     * 发送msm2
     *
     * @return {@link CompletableFuture}<{@link Integer}>
     * @throws InterruptedException 中断异常
     */
    @Async//表明该方法是一个异步方法
    public CompletableFuture<Integer> sendMSM2() throws InterruptedException {
        System.out.println("调用短信方法2....");
        long startTime = System.currentTimeMillis();
        Thread.sleep(5000);
        int interval=235432;
        long endTime = System.currentTimeMillis();
        System.out.println("短信方法完成2，耗时："+(endTime-startTime));
        return CompletableFuture.completedFuture(interval);
    }

    /**
     * 发送msm3
     *
     * @return {@link CompletableFuture}<{@link Integer}>
     * @throws InterruptedException 中断异常
     */
    @Async//表明该方法是一个异步方法

    public CompletableFuture<Integer> sendMSM3() throws InterruptedException {
        System.out.println("调用短信方法3....");
        long startTime = System.currentTimeMillis();
        Thread.sleep(3000);
        int interval=234232;
        long endTime = System.currentTimeMillis();
        System.out.println("短信方法完成3，耗时："+(endTime-startTime));
        return CompletableFuture.completedFuture(interval);
    }
}
