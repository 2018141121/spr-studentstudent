package com.codel.bolg.service.impl;

import com.codel.bolg.dao.UserMapper;
import com.codel.bolg.pojo.User;
import com.codel.bolg.service.UserService;
import com.codel.bolg.util.PageRequest;
import com.codel.bolg.util.PageResult;
import com.codel.bolg.util.PageUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> selectPage() {
        return userMapper.selectPage();
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        return PageUtils.getPageResult(pageRequest, getPageInfo(pageRequest));
    }

    /**
     * 调用分页插件完成分页
     *
     * @param pageRequest
     * @return
     */
    private PageInfo<?> getPageInfo(PageRequest pageRequest) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<User> sysMenus = userMapper.selectPage();
        return new PageInfo<>(sysMenus);
    }

}
