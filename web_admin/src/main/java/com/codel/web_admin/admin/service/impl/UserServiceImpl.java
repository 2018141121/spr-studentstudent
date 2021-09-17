package com.codel.web_admin.admin.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.codel.web_admin.admin.bean.User;
import com.codel.web_admin.admin.mapper.UserMapper;
import com.codel.web_admin.admin.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {


}
