package com.wb.dao;

import com.wb.domain.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 * 账户dao接口
 *
 */
@Repository
public interface AccountDao {
    //查询所有
     @Select("select * from account")
     List<Account> findAll();
    //保存账户信息
     @Insert("insert into account values(default,#{name},#{money})")
     void saveAccount(Account account);
}
