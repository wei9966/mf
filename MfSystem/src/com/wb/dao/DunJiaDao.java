package com.wb.dao;

import com.wb.pojo.DunJia;

import java.util.List;

/**
 * 吨价Dao层
 */
public interface DunJiaDao {
    List<DunJia> selAllDunJia();
    int update(DunJia dunJia);
    double getDunJia(String str);
}
