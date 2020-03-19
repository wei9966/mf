package com.wb.service.impl;

import com.wb.dao.DuiZhangDao;
import com.wb.pojo.PageInfo;
import com.wb.pojo.work.DuiZhang;
import com.wb.pojo.work.Work;
import com.wb.service.DuiZhangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("duiZhangService")
public class DuiZhangServiceImpl implements DuiZhangService {
    @Autowired
    private DuiZhangDao duiZhangDao;
    @Override
    public List<DuiZhang> selAll() {
        return duiZhangDao.selAll();
    }

    @Override
    public PageInfo selBycName(PageInfo pageInfo,String cName) {
        int pageSize=pageInfo.getPageSize();
        int pageNum=pageInfo.getPageNumber();
        int start=(pageNum-1)*pageSize;
        List<Work> works = duiZhangDao.selBycName(cName,start,pageSize);
        int i = duiZhangDao.selCountBycName(cName);
        int count=i%pageSize==0?i/pageSize:i/pageSize+1;
        pageInfo.setTotal(count);
        pageInfo.setList(works);
        pageInfo.setPageStart(start);
        return pageInfo;
    }
}
