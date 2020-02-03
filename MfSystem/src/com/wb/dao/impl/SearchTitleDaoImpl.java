package com.wb.dao.impl;

import com.wb.dao.SearchTitleDao;
import com.wb.mapper.SearchTitleMapper;
import com.wb.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class SearchTitleDaoImpl implements SearchTitleDao {
    private SqlSession session = MyBatisUtil.getSession();
    private SearchTitleMapper mapper = session.getMapper(SearchTitleMapper.class);
    @Override
    public List<String> searchTitleCName() {
        List<String> list = mapper.getTitleCName();
        MyBatisUtil.closeSession();
        return list;
    }

    @Override
    public List<String> searchTitlePName() {
     List<String> list=   mapper.getTitlePName();
        MyBatisUtil.closeSession();
        return list;
    }
}
