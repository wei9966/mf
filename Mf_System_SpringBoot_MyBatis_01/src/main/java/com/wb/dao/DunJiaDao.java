package com.wb.dao;

import com.wb.pojo.DunJia;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface DunJiaDao {
    @Select(" select * from dj;")
    List<DunJia> selDunJia();
    @Update("update dj set price  = #{arg1}  where id=#{arg0} ;")
    int updateDunJ(int id, int price);
    @Select("select price from dj where ptype=#{arg0};")
    Double getDprice(String str);
}
