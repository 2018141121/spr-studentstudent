package com.codel.test.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.codel.test.entity.Department;
import com.codel.test.mapper.DepartmentMapper;
import com.codel.test.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author codel
 * @since 2021-10-24
 */
@Service
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements IDepartmentService {
    @Autowired
    DepartmentMapper departmentMapper;

    @Override
    public int getCount() {
        return departmentMapper.getCount();
    }

    @Override
    public List<Department> getDepartment() {
        return departmentMapper.getDepartment();
    }


}
