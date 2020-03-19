package com.wb.controller;

import com.google.gson.Gson;
import com.wb.pojo.BaoJia;
import com.wb.pojo.ResultMoney;
import com.wb.pojo.SBaoJia;
import com.wb.service.BaoJiaService;
import com.wb.service.HcountService;
import com.wb.service.SCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 报价 控制类
 */
@Controller
@RequestMapping("/baoJia")
public class BaoJiaController {
    @Autowired
    private BaoJiaService baoJiaService;
    @Autowired
    private HcountService hcountService;
    @Autowired
    private SCountService sCountService;
    @RequestMapping("/hcBaoJia")
    @ResponseBody
    public String   hcBaoJia(String oo){
        Date d=new Date();
        System.out.println(oo);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY/MM/dd");
        String date = simpleDateFormat.format(d);
        Gson gson = new Gson();
        BaoJia baoJia = gson.fromJson(oo, BaoJia.class);
        ResultMoney rs;
        rs=hcountService.getResult(baoJia);
        String s = gson.toJson(rs);
        baoJia.sethResultMoney(rs.getResultMoney());
        baoJia.setHfmResult(rs.getFmResult());
        baoJia.setHnxResult(rs.getNxResult());
        baoJia.setHcyResult(rs.getCyResult());
        baoJia.setHhjgResult(rs.getHjgResult());
        baoJia.setHdate(date);
        int i = baoJiaService.insHCBaoJia(baoJia);
        System.out.println("画册报价"+i);
        return s;
    }
    @RequestMapping("/skBaoJia")
    @ResponseBody
    public String   skBaoJia(String oo){
        Date d=new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY/MM/dd");
        String date = simpleDateFormat.format(d);
        Gson gson = new Gson();
        SBaoJia sBaoJia = gson.fromJson(oo, SBaoJia.class);
        ResultMoney rs;
        rs=sCountService.getResult(sBaoJia);
        String s = gson.toJson(rs);
        sBaoJia.setS_ResultMoney(rs.getResultMoney());
        sBaoJia.setS_fmResult(rs.getFmResult());
        sBaoJia.setS_nxResult(rs.getNxResult());
        sBaoJia.setS_cyResult(rs.getCyResult());
        sBaoJia.setS_hjgResult(rs.getHjgResult());
        sBaoJia.setS_date(date);
        int i = baoJiaService.insSKBaoJia(sBaoJia);
        System.out.println("书刊报价"+i);
        return s;
    }
}
