package com.lagou.dao;

import com.lagou.domain.Account;

import java.util.List;

public interface AccountDao {
    public List<Account> findAll();
}
