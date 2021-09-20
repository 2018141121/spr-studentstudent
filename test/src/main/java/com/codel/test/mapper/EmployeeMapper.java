package com.codel.test.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.codel.test.entity.Employee;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author codel
 * @since 2021-10-24
 */
public interface EmployeeMapper extends BaseMapper<Employee> {

    int getEmployee(String wedlock);
}
