package com.wb.dao;

import com.wb.pojo.work.DuiZhang;
import com.wb.pojo.work.Work;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DuiZhangDao {

    @Select("select w_cName as cName,CAST(SUM(w_result) as decimal (19,3)) as money  from t_producework group by w_cName order by money desc")
    List<DuiZhang> selAll();
    @Select("select * from t_producework where w_cName=#{cName} limit #{start},#{pageSize}")
    List<Work> selBycName(@Param("cName") String cName, @Param("start") int start, @Param("pageSize") int pageSize);
    @Select("select count(*) from t_producework where w_cName=#{cName}")
    int selCountBycName(String cName);
}
