package com.wb.dao.impl;

import com.wb.dao.DeleteDao;
import com.wb.mapper.DeleteMapper;
import com.wb.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

public class DeleteDaoImpl implements DeleteDao {
 private    SqlSession session = MyBatisUtil.getSession();
  private   DeleteMapper mapper = session.getMapper(DeleteMapper.class);
    @Override
    public int deleteBaoJiaHc(int id,int hid) {
        int i = mapper.deleteBaoJiaHc(id);
        int i1 = mapper.deleteBaoJiaHcBJ(hid);
        if (i+i1>1){
            session.commit();
        }else {
            session.rollback();
        }
        MyBatisUtil.closeSession();
        return i+i1;
    }

    @Override
    public int deleteBaoJiaSk(int id, int hid) {
        int i = mapper.deleteBaoJiaSk(id);
        int i1 = mapper.deleteBaoJiaSkBJ(hid);
        if (i+i1>1){
            session.commit();
        }else {
            session.rollback();
        }
        MyBatisUtil.closeSession();
        return i+i1;
    }
}
