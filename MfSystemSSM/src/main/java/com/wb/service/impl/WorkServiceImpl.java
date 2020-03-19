package com.wb.service.impl;

import com.wb.dao.WorkDao;
import com.wb.pojo.PageInfo;
import com.wb.pojo.work.Work;
import com.wb.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("workService")
public class WorkServiceImpl implements WorkService {
    @Autowired
    private WorkDao workDao;
    @Override
    public int insIntoWork(Work work,int id,int flag1) {
        int flag;
        flag = workDao.insWork(work);
        int i = workDao.updateProduct(id);
        switch (flag1){
            case 1:
                workDao.updateHc(id);
                break;
            case 2:
                workDao.updateSk(id);
                break;
            case 3:
                break;
        }
        return flag;
    }

    @Override
    public PageInfo selAllWork(PageInfo pageInfo) {
        int start=((pageInfo.getPageNumber()-1)*pageInfo.getPageSize());
        pageInfo.setPageStart(start);
        int i = workDao.selAllWorkCount();
        List<Work> works = workDao.selAllWork(start,pageInfo.getPageSize());
        pageInfo.setList(works);
        int count=i%pageInfo.getPageSize()==0?i/pageInfo.getPageSize():i/pageInfo.getPageSize()+1;
        pageInfo.setTotal(count);
        return pageInfo;
    }

    @Override
    public int updateWork(Work work, int id) {
        int i = workDao.updateWork(work.getW_kDate(), id,work.getW_cName(),work.getW_pName(),work.getW_hjg(),work.getW_result(),work.getW_other());
        return i;
    }
}
