package com.wb.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SearchDao {
    @Select("select w_jiTai from t_producework where w_jiTai like CONCAT('%',#{0},'%') group by w_jiTai;")
    List<String> searchJiTai(String name);
    @Select("select cName from bjjl where cName like CONCAT('%',#{0},'%') group by cName;")
    List<String> searchCName(String cName);
}
