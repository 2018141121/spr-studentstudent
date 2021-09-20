package com.codel.bolg.dao;

import com.codel.bolg.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
    /**
     * 分页查询用户
     *
     * @return
     */
    @Select("Select * from user")
    List<User> selectPage();
}
