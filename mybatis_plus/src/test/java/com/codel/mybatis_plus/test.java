package com.codel.mybatis_plus;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.codel.mybatis_plus.mybatis_plus.entity.User;
import com.codel.mybatis_plus.mybatis_plus.service.impl.UserServiceImpl;
import com.codel.mybatis_plus.pojo.Person;
import com.codel.mybatis_plus.service.PersonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class test {
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private PersonService personService;

    @Test
    public void testGet() {
        for (Person person : personService.getPersonAll()) {
            System.out.println(person);

        }
    }

    @Test
    void pagingTest() {
        //这是一个分页条件
        Page<Person> page1 = new Page<>(1, 3);
//        对perosn进行分页处理
        Page<Person> page = personService.page(page1, null);
//        查询总数
        long total = page.getTotal();
//        查询当前分页总页数
        long pages = page.getPages();
//        获取当前页
        long current = page.getCurrent();
//        得到数据
        List<Person> list = page.getRecords();
        System.out.println("所有数据：" + list);
        System.out.println("显示当前页：" + current + " 总页数 " + pages + " 页， 总数据 " + total + " 条");
    }

    @Test
    public void test01() {
        Page<User> personPage = new Page<>(1, 2);
//        QueryWrapper<Person> objectQueryWrapper = new QueryWrapper<>();
//        objectQueryWrapper.eq("name", "2345");
        Page<User> page = userService.page(personPage, null);
        List<User> records = page.getRecords();
        System.out.println(records);
//        long total = page.getTotal();
//        long current = page.getCurrent();
//        long pages = page.getPages();
//        System.out.println(total);
//        System.out.println(current);
//        System.out.println(pages);
//        p
//        System.out.println(records);
//        System.out.println(page);
    }
}
