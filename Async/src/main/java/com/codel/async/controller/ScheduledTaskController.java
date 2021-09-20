package com.codel.async.controller;

import com.codel.async.service.ScheduledTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScheduledTaskController {
    @Autowired
    private ScheduledTaskService scheduledTaskService;
    @GetMapping("/test")
    public String testTask(){
        scheduledTaskService.test1();
        return "成功";
    }
}
