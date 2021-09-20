package com.codel.async.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class ScheduledTaskService {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private Integer count1 = 1;
    private Integer count2 = 1;
    private Integer count3 = 1;

    @Scheduled(fixedRate = 60000)//一分钟执行一次
    public void test1() {
        System.out.printf("定时任务fixeRate第%s次执行，当前时间为:%s%n", count1++, dateFormat.format(new Date()));
    }

    @Scheduled(fixedDelay = 60000)//表示上一次任务执行完成之后，在指定时间后执行下一次任务
    public void test2() throws InterruptedException {
        System.out.println(String.format("定时任务fixeDelay第%s次执行，当前时间为:%s", count2++, dateFormat.format(new Date())));
        Thread.sleep(10000);
    }

    @Scheduled(cron = "0 * * * * *")//定制任务触发的时间
    public void test3() {
        System.out.println(String.format("定时任务cron第%s次执行，当前时间为:%s", count3++, dateFormat.format(new Date())));

    }
}

