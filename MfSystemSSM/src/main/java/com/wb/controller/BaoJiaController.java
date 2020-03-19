package com.wb.controller;

import com.google.gson.Gson;
import com.wb.count.Scount;
import com.wb.pojo.BaoJia;
import com.wb.pojo.ResultMoney;
import com.wb.pojo.SBaoJia;
import com.wb.service.BaoJiaService;
import com.wb.service.HcountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class BaoJiaController {
    @Autowired
    private BaoJiaService baoJiaService;
    @Autowired
    private HcountService hcountService;
    @RequestMapping("/baoJia")
    public void service(HttpServletRequest request, HttpServletResponse response)throws IOException,ServletException {
        int type = (Integer.valueOf(request.getParameter("type")));
        response.setCharacterEncoding("utf-8");
        System.out.println("报价类型"+type);
        /**
         *1.画册报价
         *2.书刊报价
         */
        switch (type){
            case 1:
                HuaCeBaoJia(request,response);
                break;
            case 2:
                ShuKanBaoJia(request,response);
                break;
            case 3:

                break;
            case 4:

                break;
        }
    }
    private void ShuKanBaoJia(HttpServletRequest req, HttpServletResponse resp)throws IOException {
        Date d=new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY/MM/dd");
        String date = simpleDateFormat.format(d);
        String oo = req.getParameter("oo");
        Gson gson = new Gson();
        SBaoJia sBaoJia = gson.fromJson(oo, SBaoJia.class);
        ResultMoney rs;
        Scount s=new Scount();
        rs=s.getResult(sBaoJia);
        sBaoJia.setS_date(date);
        sBaoJia.setS_ResultMoney(rs.getResultMoney());
        sBaoJia.setS_fmResult(rs.getFmResult());
        sBaoJia.setS_nxResult(rs.getNxResult());
        sBaoJia.setS_cyResult(rs.getCyResult());
        sBaoJia.setS_hjgResult(rs.getHjgResult());
        String s1 = gson.toJson(rs);
        System.out.println("金额"+s1);
        int i = baoJiaService.insSKBaoJia(sBaoJia);
        System.out.println(i);
        resp.setCharacterEncoding("utf-8");
        resp.getWriter().write(s1);
    }

    private void HuaCeBaoJia(HttpServletRequest req,HttpServletResponse resp) throws IOException {
        Date d=new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY/MM/dd");
        String date = simpleDateFormat.format(d);
        String oo = req.getParameter("oo");
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
        resp.setCharacterEncoding("utf-8");
        resp.getWriter().write(s);
    }

}
