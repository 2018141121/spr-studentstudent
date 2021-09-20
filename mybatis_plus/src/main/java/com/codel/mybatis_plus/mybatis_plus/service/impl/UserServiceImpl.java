package com.codel.mybatis_plus.mybatis_plus.service.impl;

import com.codel.mybatis_plus.mybatis_plus.entity.User;
import com.codel.mybatis_plus.mybatis_plus.mapper.UserMapper;
import com.codel.mybatis_plus.mybatis_plus.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author codel
 * @since 2021-09-19
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
@Autowired
private UserMapper userMapper;
    @Override
    public List<User> getlist() {
        return userMapper.getlist();
    }
}
