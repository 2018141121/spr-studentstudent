package com.codel.test.controller;


import com.alibaba.fastjson.JSONObject;
import com.codel.test.service.impl.EmployeeServiceImpl;
import com.codel.test.vo.RespBean;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author codel
 * @since 2021-10-24
 */
@RestController
@RequestMapping("/test/employee")
public class EmployeeController {
    @Autowired
    EmployeeServiceImpl employeeService;

    @PostMapping("/getEmpByW")
    public RespBean getEmpByW(@RequestBody String wedlock) throws JsonProcessingException {
        System.out.println(wedlock);
        JSONObject jsonObject = JSONObject.parseObject(wedlock);
        System.out.println(jsonObject);
        String s = (String) jsonObject.get("wedlock");
        System.out.println(s
        );
        int employee = employeeService.getEmployee(s);
        System.out.println(employee);
        if (employee == 0) {
            return RespBean.error("数据错误！");
        }
        return RespBean.ok("成功", employee);

    }

    @PostMapping("/getempbyw2")
    public RespBean getempbyw2(@RequestBody HashMap wedlock) {
        String s = (String) wedlock.get("wedlock");
        System.out.println(s);
        return RespBean.ok("ok", s);
    }
}
