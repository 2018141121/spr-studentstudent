package com.codel.mybatis_plus.mybatis_plus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.codel.mybatis_plus.mybatis_plus.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author codel
 * @since 2021-09-19
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    List<User> getlist();

//    qinjia
}
