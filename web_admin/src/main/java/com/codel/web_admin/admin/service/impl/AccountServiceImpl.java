package com.codel.web_admin.admin.service.impl;


import com.codel.web_admin.admin.bean.Account;
import com.codel.web_admin.admin.mapper.AccountMapper;
import com.codel.web_admin.admin.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountMapper accountMapper;

    public Account getAcctByid(Long id){
        return accountMapper.getAcct(id);
    }
}
