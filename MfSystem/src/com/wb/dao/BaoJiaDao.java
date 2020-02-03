package com.wb.dao;

import com.wb.pojo.BaoJia;
import com.wb.pojo.PageInfo;
import com.wb.pojo.SBaoJia;

public interface BaoJiaDao {
    int insHCBaoJia(BaoJia baoJia);
    int insSKBaoJia(SBaoJia sBaoJia);
    PageInfo selAll(PageInfo pageInfo);
    Object selS(int id,int flag);
    PageInfo selProduceNo(PageInfo pageInfo);
    PageInfo selProduceYes(PageInfo pageInfo);

    PageInfo selJuTiBaoJiaByCName(String cName,PageInfo pageInfo);

    PageInfo selJuTiBaoJiaByPName(String pName, PageInfo pa);
}
