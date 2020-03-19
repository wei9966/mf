package com.wb.service;

import com.wb.pojo.BaoJia;
import com.wb.pojo.PageInfo;
import com.wb.pojo.SBaoJia;

public interface BaoJiaService {
    int insHCBaoJia(BaoJia baoJia);
    int insSKBaoJia(SBaoJia sBaoJia);
   PageInfo selAll(PageInfo pageInfo);
   Object selSingle(int id,int flag);
    PageInfo selJuTiBaoJiaByCName(String cName,PageInfo pageInfo);
    PageInfo selJuTiBaoJiaByPName(String pName, PageInfo pa);
    PageInfo selProduceYes(PageInfo pa);
    PageInfo selProduceNo(PageInfo pa);
}
