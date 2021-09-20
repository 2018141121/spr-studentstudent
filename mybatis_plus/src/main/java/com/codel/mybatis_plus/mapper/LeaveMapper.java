package com.codel.mybatis_plus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.codel.mybatis_plus.pojo.Leave;
import com.codel.mybatis_plus.pojo.Person;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LeaveMapper extends BaseMapper<Person> {
    Leave getLeave(int lid);

    int insertleave(Leave leave);

    List<Leave> getLeaves();

    List<Leave> selectLeavesByLid(long lid);

    List<Leave> selectByUid(int uid);

    int checkByUid(int state, int id);
}
