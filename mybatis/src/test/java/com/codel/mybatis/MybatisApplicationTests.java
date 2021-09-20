package com.codel.mybatis;

import com.alibaba.druid.pool.DruidDataSource;
import com.codel.mybatis.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.HashSet;

@SpringBootTest
class MybatisApplicationTests {
    @Autowired
    UserMapper userMapper;
    @Autowired
    DataSource dataSource;
    static ThreadLocal<String> localVar = new ThreadLocal<>();

    @Test
    void contextLoads() {
        System.out.println(userMapper.getClass());
//        测试数据源是否切换成功   class com.alibaba.druid.pool.DruidDataSource
        System.out.println(dataSource.getClass());

        DruidDataSource druidDataSource = (DruidDataSource) dataSource;
        System.out.println(druidDataSource.getInitialSize());
    }

    @Test
    void testLoad() {
        ArrayList<Object> objects = new ArrayList<>();

        objects.add(1);
        objects.add(1);
        objects.add("hello");
        System.out.println(objects.get(1));
        System.out.println(objects.toString());
        System.out.println(objects.hashCode());

        int[] ints = new int[34];
        ints[1] = 12;
        ints[2] = 12;
        ints[3] = 12;
        ints[4] = 12;

        System.out.println(ints);
    }

    //
    @Test
    void tsetup() {
        HashSet<Object> objects = new HashSet<>();
        objects.add(123);
        objects.add("dff");
        objects.add("fd3");
        objects.add(123);


        System.out.println(objects);
    }

    static void printThreadLocal() {
        String s = localVar.get();
        System.out.println(s);
        localVar.remove();
    }

    @Test
    void threadLocal() {
        
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                localVar.set("localVar1");
                printThreadLocal();

                System.out.println("after remove : " + localVar.get());
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                localVar.set("localVar2");
                printThreadLocal();

                System.out.println("after remove : " + localVar.get());
            }
        });

        thread.start();
        thread2.start();
    }
}
