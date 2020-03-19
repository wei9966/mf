package com.wb.dao;

import com.wb.pojo.BaoJia;
import com.wb.pojo.BaoJiaJiLu;
import com.wb.pojo.SBaoJia;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BaoJiaDao {

    @Insert("insert into hcbj values (default,#{hdate},#{hcName},#{hpName},#{hfmType},#{hfmKs},#{hfmPs},#{hcpSize},#{hcount},#{hnxType},#{hnxKs},#{hnxPs},#{hcyKs},#{hcyPs},#{hcyType},#{hfumo},#{hzd},#{hsType},#{hh1},#{hh2},#{hh3},#{hh4},#{hh5},#{hhv1},#{hhv2},#{hhv3},#{hhv4},#{hhv5},#{hResultMoney},#{hpResult},1,(select MAX(id) from bjjl),#{hfmMs},#{hnxMs},#{hcyMs},#{hfmResult},#{hnxResult},#{hcyResult},#{hhjgResult})")
    int insHCBaoJia(BaoJia baoJia);
    @Insert("insert into bjjl values (default,#{hdate},#{hcName},#{hpName},#{hcount},#{hResultMoney},1,1);")
    int insHCBaoJiaJiLu(BaoJia bj);
    @Insert("insert into skbj values (default,#{s_date},#{s_cName},#{s_pName},#{s_fmType},#{s_fmKs},#{s_fmPs},#{s_cpSize},#{s_count},#{s_nxType},#{s_nxKs},#{s_nxPs},#{s_cyKs},#{s_cyPs},#{s_cyType},#{s_fumo},#{s_zd},#{s_sType},#{s_h1},#{s_h2},#{s_h3},#{s_h4},#{s_h5},#{s_hv1},#{s_hv2},#{s_hv3},#{s_hv4},#{s_hv5},#{s_ResultMoney},#{s_pResult},1,(select MAX(id) from bjjl),#{s_fmMs},#{s_nxMs},#{s_cyMs},#{s_fmResult},#{s_nxResult},#{s_cyResult},#{s_hjgResult})")
    int insSKBaoJiaJiLu(SBaoJia bj);
    @Insert("insert into bjjl values (default,#{s_date},#{s_cName},#{s_pName},#{s_count},#{s_ResultMoney},2,1);")
    int insSKBaoJia(SBaoJia sBaoJia);
    //查询所有
    @Select({"<script>",
            "select * from bjjl where 1=1 <if test=\"cName!=null and cName != ''\"> and cName=#{cName} </if> " ,
            "<if test=\"pName!=null and pName != '' \"> and pName=#{pName} </if>",
            " order by id desc limit #{pageStart},#{pageSize}",
            "</script>"
    })
    List<BaoJiaJiLu> selAll(@Param("pageStart") int pageStart,@Param("pageSize") int pageSize,@Param("cName") String cName,@Param("pName")String pName);
    @Select({"<script>",
            "select count(*) from bjjl where 1=1 <if test=\"cName!=null and cName != ''\"> and cName=#{cName} </if>" ,
            "<if test=\"pName!=null and pName != ''\"> and pName=#{pName} </if>",
            "</script>"
    })
    int selCount(@Param("cName")String cName,@Param("pName")String pName);
    //查询具体单个
    //画册
    @Select("select * from hcbj where #{arg0}=hbjjl;")
    BaoJia selSinBao(int id);
    //书刊
    @Select("select * from skbj where #{arg0}=s_bjjl;")
    SBaoJia selSinSbao(int id);
    //查询未生产工单
    @Select({"<script>",
            "select * from bjjl where pFlag=1 <if test=\"cName!=null and cName != ''\"> and cName=#{cName} </if> " ,
            "<if test=\"pName!=null and pName != '' \"> and pName=#{pName} </if>",
            " order by id desc limit #{arg0},#{arg1}",
            "</script>"
    })
    List<BaoJiaJiLu> selProduceNo(int pageStart, int pageSize,@Param("cName")String cName,@Param("pName")String pName);
    //查询已生产工单
    @Select({"<script>",
            "select * from bjjl where pFlag=2 <if test=\"cName!=null and cName != ''\"> and cName=#{cName} </if> " ,
            "<if test=\"pName!=null and pName != '' \"> and pName=#{pName} </if>",
            " order by id desc limit #{arg0},#{arg1}",
            "</script>"
    })
    List<BaoJiaJiLu> selProduceYes(int pageStart, int pageSize,@Param("cName")String cName,@Param("pName")String pName);
    //    查询已经生产条数
    @Select({"<script>",
            "select count(*) from bjjl where pFlag=2 <if test=\"cName!=null and cName != ''\"> and cName=#{cName} </if>" ,
            "<if test=\"pName!=null and pName != ''\"> and pName=#{pName} </if>",
            "</script>"
    })
    int  selProduceYesCount(@Param("cName")String cName,@Param("pName")String pName);
    //    未生产条数
    @Select({"<script>",
            "select count(*) from bjjl where pFlag=1 <if test=\"cName!=null and cName != ''\"> and cName=#{cName} </if>" ,
            "<if test=\"pName!=null and pName != ''\"> and pName=#{pName} </if>",
            "</script>"
    })
    int  selProduceNoCount(@Param("cName")String cName,@Param("pName")String pName);
    //    根据客户名称查询
    @Select("select * from bjjl where cName=#{arg2} order by id desc limit #{arg0},#{arg1};")
    List<BaoJiaJiLu> selByCName(int pageStart, int pageSize, String name);
    //    查询客户名称的条数
    @Select("select count(*) from bjjl where cName=#{arg0};")
    int selByCNameCount(String name);
    @Select("select * from bjjl where pName=#{arg2} order by id desc limit #{arg0},#{arg1};")
    List<BaoJiaJiLu> selByPName(int start, int pageSize, String pName);
    @Select("select count(*) from bjjl where pName=#{arg0};")
    int selByPNameCount(String pName);
}
