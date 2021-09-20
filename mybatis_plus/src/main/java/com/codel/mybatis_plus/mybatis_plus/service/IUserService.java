package com.codel.mybatis_plus.mybatis_plus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.codel.mybatis_plus.mybatis_plus.entity.User;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author codel
 * @since 2021-09-19
 */
public interface IUserService extends IService<User> {
    List<User> getlist();
}
