package com.codel.test.controller;


import com.codel.test.entity.Department;
import com.codel.test.service.impl.DepartmentServiceImpl;
import com.codel.test.vo.RespBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author codel
 * @since 2021-10-24
 */
@RestController
@RequestMapping("/test/department")
public class DepartmentController {
    @Autowired
    DepartmentServiceImpl departmentService;

    @GetMapping("/getData")
    public RespBean testData() {
        int count = departmentService.getCount();
        return new RespBean(200, "成功", count);
    }

    @GetMapping("/getData2")
    public RespBean testdata1() {
        List<Department> department = departmentService.getDepartment();
        return RespBean.ok("ok", department);
    }
}
