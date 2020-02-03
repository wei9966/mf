package com.wb.mapper;

import com.wb.pojo.DunJia;

import java.util.List;

public interface DunJiaMapper {
   List<DunJia> selDunJia();
   int updateDunJ(int id,int price);
   int getDprice(String str);
}
