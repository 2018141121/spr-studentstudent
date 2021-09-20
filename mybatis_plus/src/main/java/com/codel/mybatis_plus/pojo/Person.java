package com.codel.mybatis_plus.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}

