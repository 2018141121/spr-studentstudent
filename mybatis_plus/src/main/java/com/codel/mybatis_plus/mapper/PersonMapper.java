package com.codel.mybatis_plus.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.codel.mybatis_plus.pojo.Person;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 人映射器  //把方法注入容器里面  如果不想每一个都写，就在启动类里面配置
 *
 * @author codel
 * @date 2021/09/18
 */
@Mapper
public interface PersonMapper extends BaseMapper<Person> {
    /**
     * 得到所有对象
     *
     * @return {@link List}<{@link Person}>
     */
    List<Person> getPersonAll();


}

