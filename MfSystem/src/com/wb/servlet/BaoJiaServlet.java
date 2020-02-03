package com.wb.servlet;

import com.google.gson.Gson;
import com.wb.count.Hcount;
import com.wb.count.Scount;
import com.wb.pojo.BaoJia;
import com.wb.pojo.ResultMoney;
import com.wb.pojo.SBaoJia;
import com.wb.service.BaoJiaService;
import com.wb.service.impl.BaoJiaServiceImple;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@javax.servlet.annotation.WebServlet(name = "BaoJiaServlet",urlPatterns = "/baoJia")
public class BaoJiaServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int type = (Integer.valueOf(req.getParameter("type")));
        System.out.println("报价类型"+type);
        /**
         *1.画册报价
         *2.书刊报价
         */
        switch (type){
            case 1:
                HuaCeBaoJia(req,resp);
                break;
            case 2:
                ShuKanBaoJia(req,resp);
                break;
            case 3:

                break;
            case 4:

                break;
        }
    }

    private void ShuKanBaoJia(HttpServletRequest req, HttpServletResponse resp)throws IOException{
        BaoJiaService bj=new BaoJiaServiceImple();
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
        int i = bj.insSKBaoJia(sBaoJia);
        System.out.println(i);
        resp.setCharacterEncoding("utf-8");
        resp.getWriter().write(s1);
    }

    private void HuaCeBaoJia(HttpServletRequest req,HttpServletResponse resp) throws IOException {
        BaoJiaService bj=new BaoJiaServiceImple();
        Date d=new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY/MM/dd");
        String date = simpleDateFormat.format(d);
        String oo = req.getParameter("oo");
        Gson gson = new Gson();
        BaoJia baoJia = gson.fromJson(oo, BaoJia.class);
        ResultMoney rs;
        Hcount h=new Hcount();
        rs=h.getResult(baoJia);
        String s = gson.toJson(rs);
        baoJia.sethResultMoney(rs.getResultMoney());
        baoJia.setHfmResult(rs.getFmResult());
        baoJia.setHnxResult(rs.getNxResult());
        baoJia.setHcyResult(rs.getCyResult());
        baoJia.setHhjgResult(rs.getHjgResult());
        baoJia.setHdate(date);
        int i = bj.insHCBaoJia(baoJia);
        System.out.println("画册报价"+i);
        resp.setCharacterEncoding("utf-8");
        resp.getWriter().write(s);
    }
}
