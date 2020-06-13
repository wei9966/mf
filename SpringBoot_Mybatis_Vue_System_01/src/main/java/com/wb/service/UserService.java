package com.wb.service;

import com.wb.pojo.User;

/**
 * Create By WeiBin on 2020/3/22 23:49
 */
public interface UserService {
    User VerifitUser(String username, String password);
}
