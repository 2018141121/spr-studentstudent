package com.codel.async.controller;

import com.codel.async.service.MyAsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * 我的异步控制器
 *
 * @author codel
 * @date 2021/09/23
 */
@RestController
public class MyAsyncController {
    @Autowired
    private MyAsyncService myAsyncService;

    /**
     * 测试
     *
     * @return {@link String}
     * @throws InterruptedException 中断异常
     */
    @GetMapping("/sendmail")
    public String test() throws InterruptedException {
        long startTime = System.currentTimeMillis();
//        模拟发送邮件  因为是异步，而且没有数据返回的时候，所以主线程会先走，不会等待事务完成再走。
        myAsyncService.sendMSM();
        long endTime = System.currentTimeMillis();
        System.out.println("主线程耗时:" + (endTime - startTime));
        return "信息发送成功！";
    }

    /**
     * test2
     *
     * @return {@link String}
     * @throws InterruptedException 中断异常
     * @throws ExecutionException   执行异常
     */
    @GetMapping("/sendmail2")
    public String test2() throws InterruptedException, ExecutionException {
        long startTime = System.currentTimeMillis();
//        模拟发送邮件  因为是异步，而且没有数据返回的时候，所以主线程会先走，不会等待事务完成再走。
        CompletableFuture<Integer> msm2 = myAsyncService.sendMSM2();
        CompletableFuture<Integer> msm3 = myAsyncService.sendMSM3();
        int i = msm2.get() + msm3.get();
        System.out.println("异步任务数据统计汇总结果："+i);
        long endTime = System.currentTimeMillis();
        System.out.println("主线程耗时2:" + (endTime - startTime));
        return "信息发送成功2！";
    }
}
