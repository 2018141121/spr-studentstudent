package com.codel.web_admin.admin.mapper;


import com.codel.web_admin.admin.bean.Account;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountMapper {


    public Account getAcct(Long id);
}
