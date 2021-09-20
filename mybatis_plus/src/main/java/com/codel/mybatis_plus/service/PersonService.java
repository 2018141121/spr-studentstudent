package com.codel.mybatis_plus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.codel.mybatis_plus.pojo.Person;

import java.util.List;

//继承这个接口，里面都是写好的sql语句，可以直接调用
public interface PersonService extends IService<Person> {
    List<Person> getPersonAll();

}

