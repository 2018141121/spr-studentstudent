package com.codel.jpa.mapper;

import com.codel.jpa.pojo.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

}

