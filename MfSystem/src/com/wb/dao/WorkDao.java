package com.wb.dao;

import com.wb.pojo.PageInfo;
import com.wb.pojo.work.Work;

public interface WorkDao {
    /**
     * 添加进入工单以及更新状态
     * @param work
     * @param id
     * @param flag1
     * @return
     */
    int insInToWork(Work work,int id,int flag1);
    /**
     * 分页查询所有的工单
     * @param pageInfo
     * @return
     */
    PageInfo selAllWork(PageInfo pageInfo);
    /**
     * 修改工单
     * @param work 具体修改的工单
     * @param id 工单ID
     * @return
     */
    int updateWork(Work work,int id);
}
