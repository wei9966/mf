package com.wb.service.impl;

import com.wb.dao.WorkDao;
import com.wb.dao.impl.WorkDaoImpl;
import com.wb.pojo.PageInfo;
import com.wb.pojo.work.Work;
import com.wb.service.WorkService;

public class WorkServiceImpl implements WorkService {
        WorkDao wd=new WorkDaoImpl();
    @Override
    public int insIntoWork(Work work,int id,int flag) {
    return wd.insInToWork(work,id,flag);
    }

    @Override
    public PageInfo getAllWork(PageInfo pi) {
        return wd.selAllWork(pi);
    }

    @Override
    public int updateWork(Work work, int id) {
        return wd.updateWork(work,id);
    }
}
