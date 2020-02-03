package com.wb.dao.impl;

import com.wb.dao.WorkDao;
import com.wb.mapper.WorkMapper;
import com.wb.pojo.PageInfo;
import com.wb.pojo.work.Work;
import com.wb.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class WorkDaoImpl implements WorkDao {
    private SqlSession session=MyBatisUtil.getSession();
    private  WorkMapper mapper = session.getMapper(WorkMapper.class);

    /**
     * 添加进入工单
     * @param work 具体工单
     * @param id    指的是比较记录的ID
     * @param flag1 指的是报价的类型
     * @return
     */
    @Override
    public int insInToWork(Work work,int id,int flag1) {
        int flag;
        flag = mapper.insWork(work);
        int i = mapper.updateProduct(id);
        switch (flag1){
            case 1:
                mapper.updateHc(id);
                break;
            case 2:
                mapper.updateSk(id);
                break;
            case 3:
                break;

        }
        if (flag>0){
            session.commit();
        }else {
            session.rollback();
        }
        MyBatisUtil.closeSession();
        return flag;
    }

    /**
     * 分页查询所有的工单
     * @param pageInfo
     * @return
     */
    @Override
    public PageInfo selAllWork(PageInfo pageInfo) {
        int start=((pageInfo.getPageNumber()-1)*pageInfo.getPageSize());
        pageInfo.setPageStart(start);
        int i = mapper.selAllWorkCount();
        List<Work> works = mapper.selAllWork(start,pageInfo.getPageSize());
        pageInfo.setList(works);
        int count=i%pageInfo.getPageSize()==0?i/pageInfo.getPageSize():i/pageInfo.getPageSize()+1;
        pageInfo.setTotal(count);
        return pageInfo;
    }

    /**
     * 修改工单
     * @param work 具体修改的工单
     * @param id 工单ID
     * @return
     */
    @Override
    public int updateWork(Work work, int id) {
        int i = mapper.updateWork(work.getW_kDate(), id,work.getW_cName(),work.getW_pName(),work.getW_hjg(),work.getW_result(),work.getW_other());
        if (i>0){
            session.commit();
        }else {
            session.rollback();
        }
        MyBatisUtil.closeSession();
        return i;
    }
}
