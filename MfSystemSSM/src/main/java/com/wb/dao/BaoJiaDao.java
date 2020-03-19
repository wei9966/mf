package com.wb.dao;

import com.wb.pojo.BaoJia;
import com.wb.pojo.BaoJiaJiLu;
import com.wb.pojo.SBaoJia;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
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
    @Select("select * from bjjl  order by id desc limit #{0},#{1};")
    List<BaoJiaJiLu> selAll(int pageStart,int pageSize);
    @Select("select count(*) from bjjl;")
    int selCount();
    //查询具体单个
    //画册
    @Select("select * from hcbj where #{0}=hbjjl;")
    BaoJia selSinBao(int id);
    //书刊
    @Select("select * from skbj where #{0}=s_bjjl;")
    SBaoJia selSinSbao(int id);
    //查询未生产工单
    @Select("select * from bjjl where pFlag=1 order by id desc limit #{0},#{1};")
    List<BaoJiaJiLu> selProduceNo(int pageStart, int pageSize);
    //查询已生产工单
    @Select("select * from bjjl  where pFlag=2 order by id desc limit #{0},#{1};")
    List<BaoJiaJiLu> selProduceYes(int pageStart,int pageSize);
    //    查询已经生产条数
    @Select("select count(*) from bjjl where pFlag=2;")
    int  selProduceYesCount();
    //    未生产条数
    @Select("select count(*) from bjjl where pFlag=1;")
    int  selProduceNoCount();
    //    根据客户名称查询
    @Select("select * from bjjl where cName=#{2} order by id desc limit #{0},#{1};")
    List<BaoJiaJiLu> selByCName(int pageStart,int pageSize,String name);
    //    查询客户名称的条数
    @Select("select count(*) from bjjl where cName=#{0};")
    int selByCNameCount(String name);
    @Select("select * from bjjl where pName=#{2} order by id desc limit #{0},#{1};")
    List<BaoJiaJiLu> selByPName(int start, int pageSize, String pName);
    @Select("select count(*) from bjjl where pName=#{0};")
    int selByPNameCount(String pName);
}
