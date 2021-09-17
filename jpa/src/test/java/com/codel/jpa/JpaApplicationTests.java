package com.codel.jpa;

import com.codel.jpa.mapper.UserRepository;
import com.codel.jpa.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class JpaApplicationTests {
    @Autowired
    UserRepository userRepository;
    @Autowired
    User user;

    @Test
    void contextLoads() {
        Optional<User> byId = userRepository.findById(19);
        System.out.println(byId);
    }

    @Test
    User print() {
        return user;
    }

}
