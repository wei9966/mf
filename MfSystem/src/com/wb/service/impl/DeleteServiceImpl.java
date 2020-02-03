package com.wb.service.impl;

import com.wb.dao.DeleteDao;
import com.wb.dao.impl.DeleteDaoImpl;
import com.wb.service.DeleteService;

public class DeleteServiceImpl implements DeleteService {
    DeleteDao dd=new DeleteDaoImpl();
    @Override
    public int deleteBaoJiaHc(int id,int hid) {
      return   dd.deleteBaoJiaHc(id,hid);
    }

    @Override
    public int deleteBaoJiaSk(int id, int hid) {
        return dd.deleteBaoJiaSk(id,hid);
    }
}
