package com.wb.dao.impl;

import com.wb.dao.DunJiaDao;
import com.wb.mapper.DunJiaMapper;
import com.wb.pojo.DunJia;
import com.wb.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class DunJiaDaoImpl implements DunJiaDao {
 private    SqlSession session = MyBatisUtil.getSession();
    private  DunJiaMapper mapper = session.getMapper(DunJiaMapper.class);
    @Override
    public List<DunJia> selAllDunJia() {
        List<DunJia> dunJias = mapper.selDunJia();
        MyBatisUtil.closeSession();
        return dunJias;
    }

    @Override
    public int update(DunJia dunJia) {
        int i = mapper.updateDunJ(dunJia.getId(), dunJia.getPrice());
        if (i>0){
            session.commit();
        }else {
            session.rollback();
        }
        MyBatisUtil.closeSession();
        return i;
    }

    @Override
    public double getDunJia(String str) {
        return mapper.getDprice(str);
    }

}
