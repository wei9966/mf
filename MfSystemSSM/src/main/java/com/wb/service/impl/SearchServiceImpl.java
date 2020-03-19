package com.wb.service.impl;

import com.wb.dao.SearchDao;
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
}
