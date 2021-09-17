package com.codel.mybatis;

import com.alibaba.druid.pool.DruidDataSource;
import com.codel.mybatis.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;

@SpringBootTest
class MybatisApplicationTests {
    @Autowired
    UserMapper userMapper;
    @Autowired
    DataSource dataSource;

    @Test
    void contextLoads() {
        System.out.println(userMapper.getClass());
//        测试数据源是否切换成功   class com.alibaba.druid.pool.DruidDataSource
        System.out.println(dataSource.getClass());

        DruidDataSource druidDataSource = (DruidDataSource) dataSource;
        System.out.println(druidDataSource.getInitialSize());
    }

}
