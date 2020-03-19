package com.wb.service.impl;

import com.wb.dao.DunJiaDao;
import com.wb.pojo.DunJia;
import com.wb.service.DunJiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("dunJiaService")
public class DunJiaServiceImpl implements DunJiaService {
    @Autowired
        private DunJiaDao dunJiaDao;
    @Override
    public List<DunJia> getDunJia() {
        return dunJiaDao.selDunJia();

    }

    @Override
    public int updateDJ(DunJia dunJia) {
        int i = dunJiaDao.updateDunJ(dunJia.getId(), dunJia.getPrice());
        return i;
    }

    @Override
    public Double getDunJia(String type) {
        return  dunJiaDao.getDprice(type);
    }

}
