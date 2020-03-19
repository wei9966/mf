package com.wb.service;

import com.wb.pojo.PageInfo;
import com.wb.pojo.work.DuiZhang;

import java.util.List;

public interface DuiZhangService {
    List<DuiZhang> selAll();

    PageInfo selBycName(PageInfo pageInfo,String cName);
}
