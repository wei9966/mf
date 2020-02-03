package com.wb.service.impl;

import com.wb.dao.DunJiaDao;
import com.wb.dao.impl.DunJiaDaoImpl;
import com.wb.pojo.DunJia;
import com.wb.service.DunJiaService;

import java.util.List;

public class DunJiaServiceImpl implements DunJiaService {
        DunJiaDao d=new DunJiaDaoImpl();
    @Override
    public List<DunJia> getDunJia() {

        return d.selAllDunJia();

    }

    @Override
    public int updateDJ(DunJia dunJia) {

        return d.update(dunJia);
    }
}
