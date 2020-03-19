package com.wb.service.impl;

import com.wb.dao.DeleteDao;
import com.wb.service.DeleteService;
import com.wb.util.MyBatisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("deleteService")
public class DeleteServiceImpl implements DeleteService {

    @Autowired
    private DeleteDao deleteDao;
    @Override
    public int deleteBaoJiaHc(int id,int hid) {
        int i = deleteDao.deleteBaoJiaHc(id);
        int i1 = deleteDao.deleteBaoJiaHcBJ(hid);
        MyBatisUtil.closeSession();
        return i+i1;
    }

    @Override
    public int deleteBaoJiaSk(int id, int hid) {
        int i = deleteDao.deleteBaoJiaSk(id);
        int i1 = deleteDao.deleteBaoJiaSkBJ(hid);
        MyBatisUtil.closeSession();
        return i+i1;
    }
}
