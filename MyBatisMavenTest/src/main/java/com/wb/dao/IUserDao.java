package com.wb.dao;

import com.wb.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 在mybatis中针对crud一共有四个注解
 * @Select @Insert @Update @Delete
 */
public interface IUserDao {
    /**
     * 查询所有
     * @return
     */
    @Select("select * from user")
    List<User> findAll();

    /**
     * 保存用户
     * @param user
     */
    @Insert("insert into user(username,address,sex,birthday) values(#{username},#{address},#{sex},#{birthday}) ")
    void saveUser(User user);
}
