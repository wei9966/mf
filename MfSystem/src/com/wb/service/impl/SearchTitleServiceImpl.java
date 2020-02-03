package com.wb.service.impl;

import com.wb.dao.SearchTitleDao;
import com.wb.dao.impl.SearchTitleDaoImpl;
import com.wb.service.SearchTitleService;

import java.util.List;

public class SearchTitleServiceImpl implements SearchTitleService {
    SearchTitleDao std=new SearchTitleDaoImpl();
    @Override
    public List<String> searchTitleCName() {
        return std.searchTitleCName();
    }

    @Override
    public List<String> searchTitlePName() {
        return std.searchTitlePName();
    }
}
