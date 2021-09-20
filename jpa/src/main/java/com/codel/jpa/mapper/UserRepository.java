package com.codel.jpa.mapper;

import com.codel.jpa.pojo.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {
    @Query("select * from User where name like %string% " )
    List<User> findUserByName(String string );

}

