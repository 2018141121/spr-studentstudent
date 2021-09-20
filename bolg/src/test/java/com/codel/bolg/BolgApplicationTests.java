package com.codel.bolg;

import com.codel.bolg.pojo.User;
import com.codel.bolg.service.impl.UserServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class BolgApplicationTests {
    @Autowired
    UserServiceImpl userService;

    @Test
    void contextLoads() {
        Page<Object> objects = PageHelper.startPage(1, 1);
        System.out.println(objects);
        List<User> users = userService.selectPage();
        PageInfo<User> userPageInfo = new PageInfo<>(users);
        System.out.println(userPageInfo.getList());
        System.out.println(userPageInfo);
    }

}
