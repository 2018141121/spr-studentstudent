package com.codel.mybatis_plus.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.codel.mybatis_plus.pojo.Person;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

//把方法注入容器里面  如果不想每一个都写，就在启动类里面配置
@Mapper
public interface PersonMapper extends BaseMapper<Person> {
    List<Person> getPersonAll();


}

