package com.wb.dao;

import com.wb.pojo.DunJia;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DunJiaDao {
    @Select(" select * from dj;")
    List<DunJia> selDunJia();
    @Update("update dj set price  = #{1}  where id=#{0} ;")
    int updateDunJ(int id,int price);
    @Select("select price from dj where ptype=#{0};")
    Double getDprice(String str);
}
