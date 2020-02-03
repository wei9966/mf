package com.wb.mapper;

import com.wb.pojo.BaoJia;
import com.wb.pojo.BaoJiaJiLu;
import com.wb.pojo.SBaoJia;

import java.util.List;

/**
 * 报价映射类
 */
public interface BaoJiaMapper {
    int insHCBaoJia(BaoJia baoJia);
    int insHCBaoJiaJiLu(BaoJia bj);
    int insSKBaoJiaJiLu(SBaoJia bj);
    int insSKBaoJia(SBaoJia sBaoJia);
    //查询所有
    List<BaoJiaJiLu> selAll(int pageStart,int pageSize);
    int selCount();
    //查询具体单个
    //画册
    BaoJia selSinBao(int id);
    //书刊
    SBaoJia selSinSbao(int id);

    //查询未生产工单
    List<BaoJiaJiLu> selProduceNo(int pageStart,int pageSize);
    //查询已生产工单
    List<BaoJiaJiLu> selProduceYes(int pageStart,int pageSize);
//    查询已经生产条数
    int  selProduceYesCount();
//    未生产条数
    int  selProduceNoCount();

//    根据客户名称查询
    List<BaoJiaJiLu> selByCName(int pageStart,int pageSize,String name);
//    查询客户名称的条数
    int selByCNameCount(String name);


    List<BaoJiaJiLu> selByPName(int start, int pageSize, String pName);

    int selByPNameCount(String pName);
}
