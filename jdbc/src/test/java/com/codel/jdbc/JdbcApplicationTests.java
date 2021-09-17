package com.codel.jdbc;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

@Slf4j
@SpringBootTest
class JdbcApplicationTests {
    @Autowired
    JdbcTemplate jdbcTemplate;

    //直接jdbcTemplate模板里面的方法
    @Test
    void contextLoads() {

        Long aLong = jdbcTemplate.queryForObject("select  count(*)  from user", long.class);
        System.out.println(aLong);

    }

}
