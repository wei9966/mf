package com.wb.service.impl;

import com.wb.dao.SearchDao;
import com.wb.pojo.BaoJia;
import com.wb.pojo.BaoJiaJiLu;
import com.wb.pojo.PageInfo;
import com.wb.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("searchService")
public class SearchServiceImpl implements SearchService {
    @Autowired
    private SearchDao searchDao;

    @Override
    public List<String> searchJiTai(String name) {
        return searchDao.searchJiTai(name);
    }

    @Override
    public List<String> searchCName(String cName) {
        return searchDao.searchCName(cName);
    }

    @Override
    public PageInfo searchBaoJiaByAny(PageInfo pageInfo,String cName,String pName) {
        int pageSize=pageInfo.getPageSize();
        int start=(pageInfo.getPageNumber()-1)*pageSize;
        List<BaoJiaJiLu> baoJias = searchDao.searchBaoJiaByAny(cName,pName,start,pageSize);
        int i=searchDao.searchBaoJiaByAnyCount(cName,pName);
        int count=i%pageSize==0?i/pageSize:i/pageSize+1;
        pageInfo.setTotal(count);
        pageInfo.setList(baoJias);
        return pageInfo;
    }

}
