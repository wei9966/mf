package com.wb.service;

import java.util.List;

public interface SearchService {

    List<String> searchJiTai(String name);

    List<String> searchCName(String cName);
}
