package com.codel.mybatis.mapper;

import com.codel.mybatis.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

//注解把sql的语句的组件放进容器里面
@Mapper
public interface UserMapper {

    @Select("select * from user ")
    List<User> getUsers();

    List<User> getUserByName(String name);

    User getUserById(Integer id);

    @Delete("delete from user where id = #{id}")
    int deleteById(int id);

    @Update("Update user set name=#{name},password=#{password},email=#{email} where id = #{id}")
    int updateUser(User user);

    @Insert("insert into  user values (#{id},#{name},#{password},#{email}) ")
    int insertUser(User user);
}
