package com.wb.service;

import com.wb.pojo.DunJia;

import java.util.List;

/**
 * 吨价服务层
 */
public interface DunJiaService {
    List<DunJia> getDunJia();
    int updateDJ(DunJia dunJia);
    Double getDunJia(String type);

}
