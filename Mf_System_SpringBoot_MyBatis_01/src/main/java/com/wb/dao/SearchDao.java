package com.wb.dao;

import com.wb.pojo.BaoJiaJiLu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SearchDao {
    @Select("select w_jiTai from t_producework where w_jiTai like CONCAT('%',#{arg0},'%') group by w_jiTai;")
    List<String> searchJiTai(String name);
    @Select("select cName from bjjl where cName like CONCAT('%',#{arg0},'%') group by cName;")
    List<String> searchCName(String cName);
    @Select({"<script>",
            "select * from bjjl where 1=1",
            "<if test=\"cName!=null and cName != ''\">",
            " AND cName=#{cName} ",
            "</if>",
            "<if test=\"pName!=null and pName != ''\">",
            "and pName=#{pName}",
            "</if>",
            "limit #{start},#{size}",
            "</script>"
    })
    List<BaoJiaJiLu> searchBaoJiaByAny(@Param("cName")String cName, @Param("pName")String pName, @Param("start") int start, @Param("size") int pageSize);
    @Select({"<script>",
            "select count(*) from bjjl where 1=1",
            "<if test=\" cName!=null and cName!='' \">",
            " AND cName=#{cName} ",
            "</if>",
            "<if test=\"pName!=null and pName!='' \">",
            "and pName=#{pName}",
            "</if>",
            "</script>"
    })
    int searchBaoJiaByAnyCount(@Param("cName") String cName,@Param("pName") String pName);
}
