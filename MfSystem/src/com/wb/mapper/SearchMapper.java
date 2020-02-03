package com.wb.mapper;

import java.util.List;

public interface SearchMapper {

    List<String> searchJiTai(String name);

    List<String> searchCName(String cName);
}
