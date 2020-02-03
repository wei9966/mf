package com.wb.service.impl;

import com.wb.dao.BaoJiaDao;
import com.wb.dao.impl.BaoJiaDaoImpl;
import com.wb.pojo.BaoJia;
import com.wb.pojo.PageInfo;
import com.wb.pojo.SBaoJia;
import com.wb.service.BaoJiaService;

public class BaoJiaServiceImple implements BaoJiaService {
    BaoJiaDao bj=new BaoJiaDaoImpl();
    @Override
    public int insHCBaoJia(BaoJia baoJia) {
        return bj.insHCBaoJia(baoJia);
    }
    @Override
    public int insSKBaoJia(SBaoJia sBaoJia) {
        return bj.insSKBaoJia(sBaoJia);
    }

    @Override
    public PageInfo selAll(PageInfo pageInfo) {
        return bj.selAll(pageInfo);
    }

    @Override
    public Object selSingle(int id, int flag) {
        return bj.selS(id,flag);
    }
}
