package com.wb.service;

import com.wb.domain.Account;

import java.util.List;

/**
 * Account service
 */
public interface AccountService {

    //查询所有
    List<Account> findAll();
    //保存账户信息
    void saveAccount(Account account);
}
