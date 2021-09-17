package com.codel.mybatis_plus.pojo;

import lombok.Data;
import org.springframework.stereotype.Repository;

@Repository
@Data
public class Person {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}

