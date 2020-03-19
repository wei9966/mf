package com.wb.dao;

import org.apache.ibatis.annotations.Delete;
import org.springframework.stereotype.Repository;

@Repository
public interface DeleteDao {
    //    删除画册
    @Delete("delete from hcbj where id=#{0};")
    int deleteBaoJiaHc(int id);
    @Delete("delete from bjjl where id=#{0};")
    int deleteBaoJiaHcBJ(int id);
    //        删除书刊
    @Delete("delete from skbj where id=#{0};")
    int deleteBaoJiaSk(int id);
    @Delete("delete from bjjl where id=#{0};")
    int deleteBaoJiaSkBJ(int hid);
}
