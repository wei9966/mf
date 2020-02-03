package com.wb.dao.impl;

import com.wb.dao.BaoJiaDao;
import com.wb.mapper.BaoJiaMapper;
import com.wb.pojo.BaoJia;
import com.wb.pojo.BaoJiaJiLu;
import com.wb.pojo.PageInfo;
import com.wb.pojo.SBaoJia;
import com.wb.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class BaoJiaDaoImpl implements BaoJiaDao {
    /**
     * 画册添加
     * @param baoJia
     * @return
     */
    @Override
    public int insHCBaoJia(BaoJia baoJia) {
        SqlSession session = MyBatisUtil.getSession();
        BaoJiaMapper mapper = session.getMapper(BaoJiaMapper.class);
        int i = mapper.insHCBaoJiaJiLu(baoJia);
        int i1 = mapper.insHCBaoJia(baoJia);
        if (i+i1>1){
            session.commit();
        }else {
            session.rollback();
        }
        MyBatisUtil.closeSession();
        return i+i1;
    }
    /**
     * 书刊添加
     */
    @Override
    public int insSKBaoJia(SBaoJia sBaoJia) {
        SqlSession session = MyBatisUtil.getSession();
        BaoJiaMapper mapper = session.getMapper(BaoJiaMapper.class);
        int i = mapper.insSKBaoJiaJiLu(sBaoJia);
        int i1 = mapper.insSKBaoJia(sBaoJia);
        if (i+i1>1){
            session.commit();
        }else {
            session.rollback();
        }
        MyBatisUtil.closeSession();
        return i+i1;
    }

    @Override
    public PageInfo selAll(PageInfo pageInfo) {
        SqlSession session = MyBatisUtil.getSession();
        BaoJiaMapper mapper = session.getMapper(BaoJiaMapper.class);
        int count = mapper.selCount();
        int pageSize = pageInfo.getPageSize();
        int pageNumber = pageInfo.getPageNumber();
        int start=(pageNumber-1)*pageSize;
        List<BaoJiaJiLu> baoJiaJiLus = mapper.selAll(start, pageSize);
        pageInfo.setPageStart(start);
        pageInfo.setList(baoJiaJiLus);
        pageInfo.setPageNumber(pageNumber);
        int total=(count%pageSize==0?count/pageSize:count/pageSize+1);
        pageInfo.setTotal(total);
        return pageInfo;
    }

    /**
     * 查询单个
     * @param id
     * @param flag
     * @return
     */
    @Override
    public Object selS(int id, int flag) {
        SqlSession session = MyBatisUtil.getSession();
        BaoJiaMapper mapper = session.getMapper(BaoJiaMapper.class);
        Object obj=null;
        switch (flag){
            case 1:
                 obj = mapper.selSinBao(id);
                break;
            case 2:
               obj = mapper.selSinSbao(id);
                break;
            case 3:
                break;
            case 4:
                break;
        }

        return obj;
    }

    /**
     *查询未生产
     * @param pageInfo
     * @return
     */
    @Override
    public PageInfo selProduceNo(PageInfo pageInfo) {
        SqlSession session = MyBatisUtil.getSession();
        BaoJiaMapper mapper = session.getMapper(BaoJiaMapper.class);
        int count = mapper.selProduceNoCount();
        int pageSize = pageInfo.getPageSize();
        int pageNumber = pageInfo.getPageNumber();
        int start=(pageNumber-1)*pageSize;
        List<BaoJiaJiLu> baoJiaJiLus = mapper.selProduceNo(start, pageSize);
        pageInfo.setPageStart(start);
        pageInfo.setList(baoJiaJiLus);
        pageInfo.setPageNumber(pageNumber);
        int total=(count%pageSize==0?count/pageSize:count/pageSize+1);
        pageInfo.setTotal(total);
        MyBatisUtil.closeSession();
        return pageInfo;
    }

    /**
     * 查询已生产
     * @param pageInfo
     * @return
     */
    @Override
    public PageInfo selProduceYes(PageInfo pageInfo) {
        SqlSession session = MyBatisUtil.getSession();
        BaoJiaMapper mapper = session.getMapper(BaoJiaMapper.class);
        int count = mapper.selProduceYesCount();
        int pageSize = pageInfo.getPageSize();
        int pageNumber = pageInfo.getPageNumber();
        int start=(pageNumber-1)*pageSize;
        pageInfo.setPageStart(start);
        List<BaoJiaJiLu> baoJiaJiLus = mapper.selProduceYes(start, pageSize);
        pageInfo.setList(baoJiaJiLus);
        pageInfo.setPageNumber(pageNumber);
        int total=(count%pageSize==0?count/pageSize:count/pageSize+1);
        pageInfo.setTotal(total);
        MyBatisUtil.closeSession();
        return pageInfo;
    }

    @Override
    public PageInfo selJuTiBaoJiaByCName(String cName, PageInfo pageInfo) {
        SqlSession session = MyBatisUtil.getSession();
        BaoJiaMapper mapper = session.getMapper(BaoJiaMapper.class);
        int start=(pageInfo.getPageNumber()-1)*pageInfo.getPageSize();
        pageInfo.setList(mapper.selByCName(start,pageInfo.getPageSize(),cName));
        int i = mapper.selByCNameCount(cName);
        int count=i%pageInfo.getPageSize()==0?i/pageInfo.getPageSize():i/pageInfo.getPageSize()+1;
        pageInfo.setTotal(count);
        pageInfo.setPageStart(start);
        return pageInfo;
    }

    @Override
    public PageInfo selJuTiBaoJiaByPName(String pName, PageInfo pageInfo) {
        SqlSession session = MyBatisUtil.getSession();
        BaoJiaMapper mapper = session.getMapper(BaoJiaMapper.class);
        int start=(pageInfo.getPageNumber()-1)*pageInfo.getPageSize();
        pageInfo.setList(mapper.selByPName(start,pageInfo.getPageSize(),pName));
        int i = mapper.selByPNameCount(pName);
        int count=i%pageInfo.getPageSize()==0?i/pageInfo.getPageSize():i/pageInfo.getPageSize()+1;
        pageInfo.setTotal(count);
        pageInfo.setPageStart(start);
        return pageInfo;
    }
}
