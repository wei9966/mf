package com.wb.dao;

import java.util.List;

public interface SearchDao {
    /**
     * 查询机台
     */
    List<String> searchJiTai(String jitai);

    List<String> searchCName(String cName);
}
