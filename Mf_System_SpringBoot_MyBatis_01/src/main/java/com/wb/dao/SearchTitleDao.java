package com.wb.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SearchTitleDao {
    @Select("select cName from bjjl group by cName;")
    List<String> selTitleCName();
    @Select("select pName from bjjl group by pName;")
    List<String> selTitlePName();
}
