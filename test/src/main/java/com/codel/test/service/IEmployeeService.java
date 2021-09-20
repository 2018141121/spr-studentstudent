package com.codel.test.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.codel.test.entity.Employee;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author codel
 * @since 2021-10-24
 */
public interface IEmployeeService extends IService<Employee> {
    int getEmployee(String wedlock);
}
