package com.wb.service.impl;

import com.wb.dao.SearchDao;
import com.wb.dao.impl.SearchDaoImpl;
import com.wb.service.SearchService;

import java.util.List;

public class SearchServiceImpl implements SearchService {

    SearchDao sd=new SearchDaoImpl();
    @Override
    public List<String> searchJiTai(String name) {
        return sd.searchJiTai(name);
    }

    @Override
    public List<String> searchCName(String cName) {
        return sd.searchCName(cName);
    }
}
