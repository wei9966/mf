package com.wb.test;

import com.wb.pojo.SBaoJia;
import com.wb.service.BaoJiaService;
import com.wb.service.impl.BaoJiaServiceImple;

public class Test {
    public static void main(String[] args) {
        SBaoJia b=new SBaoJia();
        b.setS_date("2000-01-02");
        b.setS_cName("a");
        BaoJiaService bj=new BaoJiaServiceImple();
        int i = bj.insSKBaoJia(b);
        System.out.println(i);
    }
}
