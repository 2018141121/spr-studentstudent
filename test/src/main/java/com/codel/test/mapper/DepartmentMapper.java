package com.codel.test.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.codel.test.entity.Department;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author codel
 * @since 2021-10-24
 */
//@Mapper
public interface DepartmentMapper extends BaseMapper<Department> {
    @Select("Select count(*) from Department")
    int getCount();

    List<Department> getDepartment();
}
