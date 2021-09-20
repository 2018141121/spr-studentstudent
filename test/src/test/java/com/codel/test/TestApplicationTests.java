package com.codel.test;

import com.codel.test.service.impl.EmployeeServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TestApplicationTests {
@Autowired
    EmployeeServiceImpl employeeService;
    @Test
    void contextLoads() {
    }


}
