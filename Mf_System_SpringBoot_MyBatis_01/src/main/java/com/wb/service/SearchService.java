package com.wb.service;

import com.wb.pojo.PageInfo;

import java.util.List;

public interface SearchService {

    List<String> searchJiTai(String name);

    List<String> searchCName(String cName);

    PageInfo searchBaoJiaByAny(PageInfo pageInfo,String cName,String pName);

}
