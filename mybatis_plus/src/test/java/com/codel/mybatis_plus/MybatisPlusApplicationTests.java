package com.codel.mybatis_plus;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.codel.mybatis_plus.mapper.PersonMapper;
import com.codel.mybatis_plus.mybatis_plus.entity.User;
import com.codel.mybatis_plus.mybatis_plus.service.impl.UserServiceImpl;
import com.codel.mybatis_plus.pojo.Person;
import com.codel.mybatis_plus.service.impl.PersonServiceImpl;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * mybatis +应用程序测试
 *
 * @author codel
 * @date 2021/10/10
 */
@SpringBootTest
class MybatisPlusApplicationTests implements Runnable {
    @Autowired
    PersonMapper personMapper;
    @Autowired
    PersonServiceImpl personService;
    /*
    多行注释
     */
    private Logger logger = LoggerFactory.getLogger(getClass());


    @Test
    public void testds() {
        System.out.println(personService.getPersonAll());
    }

    @Test
    public void contextLoads() {
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
    private void test01() {
        Page<Person> personPage = new Page<>(1, 2);
        QueryWrapper<Person> objectQueryWrapper = new QueryWrapper<>();
        objectQueryWrapper.eq("name", "2345");
        Page<Person> page = personService.page(personPage, objectQueryWrapper);
        long total = page.getTotal();
        long current = page.getCurrent();
        long pages = page.getPages();
        System.out.println(total);
        System.out.println(current);
        System.out.println(pages);
        List<Person> records = page.getRecords();
        System.out.println(records);
        System.out.println(page);
    }

    @Test
    protected void mpTest() {
//        创建一个条件的wrapper  主要用来创建条件的
        QueryWrapper<Person> Wrapper = new QueryWrapper<>();
//        模糊查询
        QueryWrapper<Person> name = Wrapper.like("name", "345");

        QueryWrapper<Person> objectQueryWrapper = new QueryWrapper<>();
//        根据id查询
        QueryWrapper<Person> id = objectQueryWrapper.eq("id", "16");
        System.out.println(personMapper.selectList(name));
        System.out.println(personMapper.selectOne(id));
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
    public void setPersonService() {
        logger.info("输出日志！");
    }

    @Test
    public void testPerson() {

        int i = 2 << 3;
        logger.info(String.valueOf(i));
        long round = Math.round(25.6);
        long round2 = Math.round(25.2);
        logger.info(String.valueOf(round));
        logger.info(String.valueOf(round2));
//        四舍五入的原理是在参数上加 0.5 然后进行下取整。

//        INFO 10264 --- [           main] c.c.m.MybatisPlusApplicationTests        : 26
//INFO 10264 --- [           main] c.c.m.MybatisPlusApplicationTests        : 25
    }

    //    测试单精度和双精度
    @Test
    public void testFloat() {
//        这个就一定是double类型的
        double v = 123.1;
//        添加F就会变成单精度类型的
        float v1 = 234.4F;

//        单精度转化为双精度  (强类型转化)
        float v2 = (float) v;
        System.out.println(v + "//" + v1 + "//" + v2);


        short s1 = 1;
        s1 = (short) (s1 + 1);
//有隐含的强制类型转换。
        short s2 = 1;
        s2 += 1;
    }

    private final int HEX = 34;

    @Test
    public void testShort() {
//        逻辑与和短路与
//        逻辑或和短路或
        int i = 34;
        int i1 = 34;
        if (i == 1 || i1 == 34) {
            System.out.println("短路或");
        }
        if (i == 3 && i1 == 34) {
            System.out.println("短路与");
        }
        System.out.println("false");

    }

    @Test
    public void testPrint() {
        for (int i = 0; i < 10; i++) {
            if (i == 4) {
//                跳出本次输出，继续循环
                continue;
            }
            if (i == 7) {
                break;
//                跳出本次循环
            }
            if (i == 6) {
                return;
//                不再执行下面的代码
            }
            System.out.print(i + ",");
        }
    }

    @Test
    public void test11() {

        int a1[] = {134, 234123, 432411233,};

//        数组变为arraylist的话，不能使用array的方法  要使用arraylist的方法
//        先把数组变为列表，再把列表变为arraylist  【正确的创建arraylist的方式】
        ArrayList<int[]> ints = new ArrayList<>(Arrays.asList(a1));


        ArrayList<Object> list = new ArrayList<>();
        list.add(1);
        list.add(11);
        list.add(12);
        list.add(13);
        list.add("23");
        //正确的检查数组中是否有某一个值
        for (Object o : list) {
            if (o.equals(1)) {
                System.out.println("success");
            }
        }
        //也可以直接进行验证，判断数组里面是否包含某一个值
        System.out.println(list.contains(1));


//        list里面循环删除元素应该使用的是迭代器

        Iterator<Object> iterator = list.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            if (next.equals("23")) {
                iterator.remove();
            }
            System.out.println(next);
        }
    }

    @Test
    public void testList() {
        StringBuilder stringBuffer = new StringBuilder();
        StringBuilder append = stringBuffer.append(123412);
        StringBuilder append2 = stringBuffer.append(123412);

        System.out.println(append);
        System.out.println(append2);
        System.out.println(append.equals(append2));
    }

    @Test
    public void testArray() {
        List<Person> personListByLikeName = personMapper.getPersonListByLikeName("3");
        System.out.println(personListByLikeName);
    }

    public static void main(String[] args) {
        new Thread(new MybatisPlusApplicationTests("codeL"));
        new Thread(new MybatisPlusApplicationTests("codeL2"));
    }

    private String name;

    public MybatisPlusApplicationTests(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(name + "运行" + i);
            try {
                Thread.sleep((int) Math.random() * 10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Autowired
    PersonServiceImpl kkk;

    @Test
    public void testBasic() {
        System.out.println(kkk.getPersonAll());
    }

    @Autowired
    UserServiceImpl userService;

    @Test
    public void test091() {
        Page<User> personPage = new Page<>(1, 2);
//        QueryWrapper<Person> objectQueryWrapper = new QueryWrapper<>();
//        objectQueryWrapper.eq("name", "2345");
        Page<User> page = userService.page(personPage, null);
        List<User> records = page.getRecords();
        System.out.println(records);
    }
}
