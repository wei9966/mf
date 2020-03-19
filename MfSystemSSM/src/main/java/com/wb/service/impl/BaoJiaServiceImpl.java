package com.wb.service.impl;

import com.wb.dao.BaoJiaDao;
import com.wb.pojo.BaoJia;
import com.wb.pojo.BaoJiaJiLu;
import com.wb.pojo.PageInfo;
import com.wb.pojo.SBaoJia;
import com.wb.service.BaoJiaService;
import com.wb.util.MyBatisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("baoJiaService")
public class BaoJiaServiceImpl implements BaoJiaService {
    @Autowired
    private BaoJiaDao baoJiaDao;
    @Override
    public int insHCBaoJia(BaoJia baoJia) {
        int i = baoJiaDao.insHCBaoJia(baoJia);
        int i1 = baoJiaDao.insHCBaoJiaJiLu(baoJia);
        return i+i1;
    }
    @Override
    public int insSKBaoJia(SBaoJia sBaoJia) {
        int i = baoJiaDao.insSKBaoJia(sBaoJia);
        int i1 = baoJiaDao.insSKBaoJiaJiLu(sBaoJia);
        return i+i1;
    }

    @Override
    public PageInfo selAll(PageInfo pageInfo) {
        int pageSize = pageInfo.getPageSize();
        int pageNumber = pageInfo.getPageNumber();
        int start=(pageNumber-1)*pageSize;
        List<BaoJiaJiLu> baoJiaJiLus = baoJiaDao.selAll(start,pageSize);
        int count=baoJiaDao.selCount();
        pageInfo.setPageStart(start);
        pageInfo.setList(baoJiaJiLus);
        pageInfo.setPageNumber(pageNumber);
        int total=(count%pageSize==0?count/pageSize:count/pageSize+1);
        pageInfo.setTotal(total);
        return pageInfo;
    }

    @Override
    public Object selSingle(int id, int flag) {
        Object obj=null;
        switch (flag){
            case 1:
                obj = baoJiaDao.selSinBao(id);
                break;
            case 2:
                obj = baoJiaDao.selSinSbao(id);
                break;
            case 3:
                break;
            case 4:
                break;
        }
        return obj;
    }

    @Override
    public PageInfo selJuTiBaoJiaByCName(String cName, PageInfo pageInfo) {
        int start=(pageInfo.getPageNumber()-1)*pageInfo.getPageSize();
        pageInfo.setList(baoJiaDao.selByCName(start,pageInfo.getPageSize(),cName));
        int i = baoJiaDao.selByCNameCount(cName);
        int count=i%pageInfo.getPageSize()==0?i/pageInfo.getPageSize():i/pageInfo.getPageSize()+1;
        pageInfo.setTotal(count);
        pageInfo.setPageStart(start);
        return pageInfo;
    }

    @Override
    public PageInfo selJuTiBaoJiaByPName(String pName, PageInfo pageInfo) {
        int start=(pageInfo.getPageNumber()-1)*pageInfo.getPageSize();
        pageInfo.setList(baoJiaDao.selByPName(start,pageInfo.getPageSize(),pName));
        int i = baoJiaDao.selByPNameCount(pName);
        int count=i%pageInfo.getPageSize()==0?i/pageInfo.getPageSize():i/pageInfo.getPageSize()+1;
        pageInfo.setTotal(count);
        pageInfo.setPageStart(start);
        return pageInfo;
    }

    @Override
    public PageInfo selProduceYes(PageInfo pageInfo) {
        int count = baoJiaDao.selProduceYesCount();
        int pageSize = pageInfo.getPageSize();
        int pageNumber = pageInfo.getPageNumber();
        int start=(pageNumber-1)*pageSize;
        pageInfo.setPageStart(start);
        List<BaoJiaJiLu> baoJiaJiLus = baoJiaDao.selProduceYes(start, pageSize);
        pageInfo.setList(baoJiaJiLus);
        pageInfo.setPageNumber(pageNumber);
        int total=(count%pageSize==0?count/pageSize:count/pageSize+1);
        pageInfo.setTotal(total);
        MyBatisUtil.closeSession();
        return pageInfo;
    }

    @Override
    public PageInfo selProduceNo(PageInfo pageInfo) {
        int count = baoJiaDao.selProduceNoCount();
        int pageSize = pageInfo.getPageSize();
        int pageNumber = pageInfo.getPageNumber();
        int start=(pageNumber-1)*pageSize;
        List<BaoJiaJiLu> baoJiaJiLus = baoJiaDao.selProduceNo(start, pageSize);
        pageInfo.setPageStart(start);
        pageInfo.setList(baoJiaJiLus);
        pageInfo.setPageNumber(pageNumber);
        int total=(count%pageSize==0?count/pageSize:count/pageSize+1);
        pageInfo.setTotal(total);
        MyBatisUtil.closeSession();
        return pageInfo;
    }
}
