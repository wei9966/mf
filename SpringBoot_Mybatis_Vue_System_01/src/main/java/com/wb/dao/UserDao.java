package com.wb.dao;

import com.wb.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Create By WeiBin on 2020/3/22 23:51
 * 验证用户
 */
@Mapper
public interface UserDao {
    @Select("select * from user where username=#{username} and password=#{password}")
    User validateUsers(@Param("username") String username, @Param("password") String password);
}
