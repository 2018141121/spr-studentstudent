package com.codel.mybatis_plus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.codel.mybatis_plus.mapper.PersonMapper;
import com.codel.mybatis_plus.pojo.Person;
import com.codel.mybatis_plus.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl extends ServiceImpl<PersonMapper, Person> implements PersonService {
    @Autowired
    PersonMapper personMapper;

    @Override
    public List<Person> getPersonAll() {
        return personMapper.getPersonAll();
    }

   }
