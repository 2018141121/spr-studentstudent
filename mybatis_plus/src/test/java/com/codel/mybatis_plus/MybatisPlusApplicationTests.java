package com.codel.mybatis_plus;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.codel.mybatis_plus.mapper.PersonMapper;
import com.codel.mybatis_plus.pojo.Person;
import com.codel.mybatis_plus.service.impl.PersonServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MybatisPlusApplicationTests {
    @Autowired
    PersonMapper personMapper;
    @Autowired
    PersonServiceImpl personService;

    @Test
    void contextLoads() {
        Person person = personMapper.selectById("19");
        System.out.println(person);
        List<Person> people = personMapper.selectList(null);
        for (Person person1 : people) {
            System.out.println(person1);
        }
        List<Person> personAll = personMapper.getPersonAll();
        for (Person person1 : personAll) {
            System.out.println(person1);

        }
    }

    @Test
    void test01() {
        Page<Person> personPage = new Page<>(1, 2);
        Page<Person> page = personService.page(personPage, null);
        long total = page.getTotal();
        long current = page.getCurrent();
        long pages = page.getPages();
        System.out.println(total);
        System.out.println(current);
        System.out.println(pages);
        List<Person> records = page.getRecords();
        System.out.println(records);
    }

}
