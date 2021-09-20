package com.codel.test.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.codel.test.entity.Employee;
import com.codel.test.mapper.EmployeeMapper;
import com.codel.test.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author codel
 * @since 2021-10-24
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements IEmployeeService {
    @Autowired
    EmployeeMapper employeeMapper;

    @Override
    public int getEmployee(String wedlock) {
        return employeeMapper.getEmployee(wedlock);
    }
}
