package com.wb.service;

import com.wb.pojo.PageInfo;
import com.wb.pojo.work.Work;

//工单服务层接口
public interface WorkService {
    int insIntoWork(Work work,int id,int flag1);
    PageInfo selAllWork(PageInfo pi);
    int updateWork(Work work,int id);
}
