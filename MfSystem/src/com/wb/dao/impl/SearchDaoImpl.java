package com.wb.dao.impl;

import com.wb.dao.SearchDao;
import com.wb.mapper.SearchMapper;
import com.wb.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class SearchDaoImpl  implements SearchDao
{
    private SqlSession session = MyBatisUtil.getSession();
    private SearchMapper mapper = session.getMapper(SearchMapper.class);

    @Override
    public List<String> searchJiTai(String jitai) {
        List<String> list = mapper.searchJiTai(jitai);
        MyBatisUtil.closeSession();
        return list;
    }

    @Override
    public List<String> searchCName(String cName) {
        List<String> list = mapper.searchCName(cName);
        MyBatisUtil.closeSession();
        return list;
    }
}
