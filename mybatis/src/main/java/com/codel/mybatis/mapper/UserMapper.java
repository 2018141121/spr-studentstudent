package com.codel.mybatis.mapper;

import com.codel.mybatis.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

//注解把sql的语句的组件放进容器里面
@Mapper
public interface UserMapper {

    @Select("select * from user ")
    List<User> getUsers();

    List<User> getUserByName(String name);

    User getUserById(Integer id);
}
