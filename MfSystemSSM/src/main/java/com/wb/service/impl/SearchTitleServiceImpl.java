package com.wb.service.impl;

import com.wb.dao.SearchTitleDao;
import com.wb.service.SearchTitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("searchTitleService")
public class SearchTitleServiceImpl implements SearchTitleService {
    @Autowired
   private SearchTitleDao searchTitleDao;
    @Override
    public List<String> searchTitleCName() {
        return searchTitleDao.selTitleCName();
    }

    @Override
    public List<String> searchTitlePName() {
        return searchTitleDao.selTitlePName();
    }
}
