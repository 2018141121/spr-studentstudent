package com.codel.mybatis_plus.mybatis_plus.mapper;

import com.codel.mybatis_plus.mybatis_plus.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

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

}
