package com.codel.jpa.pojo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.persistence.Entity;
import javax.persistence.Id;

//@Component
@ConfigurationProperties(prefix = "user")
@Entity
@Data
public class User {
    @Id
    private int id;
    private String name;
    private String password;
    private String email;
}
