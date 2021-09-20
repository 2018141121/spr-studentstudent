package com.codel.test.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.codel.test.entity.Department;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author codel
 * @since 2021-10-24
 */
public interface IDepartmentService extends IService<Department> {
    int getCount();

    List<Department> getDepartment();
}
