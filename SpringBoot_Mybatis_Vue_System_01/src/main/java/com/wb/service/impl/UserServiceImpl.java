package com.wb.service.impl;

import com.wb.dao.UserDao;
import com.wb.pojo.User;
import com.wb.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Create By WeiBin on 2020/3/22 23:50
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
      private UserDao userDao;
    public User VerifitUser(String username, String password) {

        return userDao.validateUsers(username,password);
    }
}
