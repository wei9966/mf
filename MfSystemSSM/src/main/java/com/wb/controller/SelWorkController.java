package com.wb.controller;

import com.google.gson.Gson;
import com.wb.pojo.BaoJia;
import com.wb.pojo.PageInfo;
import com.wb.pojo.SBaoJia;
import com.wb.pojo.work.Work;
import com.wb.service.WorkService;
import com.wb.util.CountUtil;
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
public class SelWorkController {
    @Autowired
    private WorkService workService;
@RequestMapping("/work")
    public void selWork(HttpServletRequest req, HttpServletResponse resp) throws IOException,ServletException{
    Integer type = Integer.valueOf(req.getParameter("type"));
    resp.setCharacterEncoding("utf-8");
    System.out.println("工单查询"+type);
    /**
     * 1 进入工单填写页面
     * 2 添加工单
     * 3 查询所有工单
     * 4 修改某个工单
     *
     */
    switch (type){
        case 1:
            workHtml(req,resp);
            break;
        case 2:
            insWork(req,resp);
            break;
        case 3:
            selAllWork(req,resp);
            break;
        case 4:
            updateWork(req,resp);
            break;

    }
    }
    private void updateWork(HttpServletRequest req, HttpServletResponse resp)throws IOException,ServletException {
        Gson gson = new Gson();
        String obj = req.getParameter("obj");
        String id1 = req.getParameter("id");
        int  id = Integer.valueOf(id1.substring(id1.indexOf("x")+1));
        Work work = gson.fromJson(obj, Work.class);
        int i = workService.updateWork(work,id);
        System.out.println(i);
        resp.getWriter().write("work?type=3");
    }

    private void selAllWork(HttpServletRequest req, HttpServletResponse resp)throws IOException,ServletException {
        PageInfo p=new PageInfo();
        String pageNumStr = req.getParameter("pageNum");
        int pageNum;
        if (pageNumStr==null||pageNumStr.equals("")){
            pageNum=1;
        }else {
            pageNum=Integer.valueOf(pageNumStr);
        }
        int pageSize=10;
        p.setPageSize(pageSize);
        p.setPageNumber(pageNum);
        PageInfo allWork = workService.selAllWork(p);
        req.setAttribute("work",allWork);
        req.getRequestDispatcher("gd.jsp").forward(req,resp);
    }

    /**
     * 工单生产然后添加进入数据库
     * @param req
     * @param resp
     */
    private void insWork(HttpServletRequest req, HttpServletResponse resp) throws IOException,ServletException {
        String work = req.getParameter("work");
        String w_jiTai = req.getParameter("w_jiTai");
        String w_hDate = req.getParameter("w_hDate");
        String w_other = req.getParameter("w_other");
        int flag = Integer.valueOf(req.getParameter("flag"));
        int flag1 = Integer.valueOf(req.getParameter("flag1"));
        System.out.println(flag);
        Gson gson = new Gson();
        Work work1 = gson.fromJson(work, Work.class);
        System.out.println(work1);
        work1.setW_jiTai(w_jiTai);
        work1.setW_hDate(w_hDate);
        work1.setW_other(w_other);
        int i = workService.insIntoWork(work1,flag,flag1);
        System.out.println(i);
        req.getRequestDispatcher("workPrint.jsp").forward(req,resp);
    }

    /**
     * 将数据填写进包装类并在页面中显示出来
     * @param req
     * @param resp
     * @param
     */
    private void workHtml(HttpServletRequest req, HttpServletResponse resp)throws IOException,ServletException {
        Work w=new Work();
        Date d=new Date();
        Gson gson = new Gson();
        //flag1代表的是画册还是书刊
        int flag1 = Integer.valueOf( req.getParameter("flag"));
        System.out.println(flag1);
        int flag=0;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY/MM/dd");
        String format = simpleDateFormat.format(d);
        /**
         * 看是画册还是书刊
         */
        switch (flag1){
            case 1:
                BaoJia hBaoJia = gson.fromJson(req.getParameter("BaoJia"), BaoJia.class);
                flag=hBaoJia.getHbjjl();
                w.setW_kDate(format);
                w.setW_cName(hBaoJia.getHcName());
                w.setW_pName(hBaoJia.getHpName());
                w.setW_count(hBaoJia.getHcount());
                w.setW_jDate(format);
                w.setW_cSize(hBaoJia.getHcpSize());
                w.setW_pSize(hBaoJia.getHcpSize());

                w.setW_fmPage(hBaoJia.getHfmType());
                w.setW_fmKb(CountUtil.getKaiBie(hBaoJia.getHcpSize())*2);
                w.setW_fmZcount(hBaoJia.getHcount());
                w.setW_fmFcount(CountUtil.getZount(hBaoJia.getHcount()));
                w.setW_fmHcount(w.getW_fmZcount()+w.getW_fmFcount());
                w.setW_fmYellow(hBaoJia.getHfmMs());
                w.setW_fmYCount(CountUtil.getYinBanCount(hBaoJia.getHfmPs()));

                w.setW_nxPage(hBaoJia.getHnxType());
                w.setW_nxKb(CountUtil.getKaiBie(hBaoJia.getHcpSize())*2);
                w.setW_nxZcount(hBaoJia.getHcount());
                w.setW_nxFcount(CountUtil.getZount(hBaoJia.getHcount()));
                w.setW_nxHcount(w.getW_nxZcount()+w.getW_nxFcount());
                w.setW_nxYellow(hBaoJia.getHnxMs());
                w.setW_nxYCount(CountUtil.getYinBanCount(hBaoJia.getHnxPs()));

                w.setW_cyPage(hBaoJia.getHcyType());
                if (w.getW_cyPage()==""||w.getW_cyPage().equals("")){
                    w.setW_cyKb(0);
                    w.setW_cyZcount(0);
                    w.setW_cyFcount(0);
                    w.setW_cyHcount(0);
                    w.setW_cyYellow("");
                    w.setW_cyYCount(0);
                }else{
                    w.setW_cyKb(CountUtil.getKaiBie(hBaoJia.getHcpSize())*2);
                    w.setW_cyZcount(hBaoJia.getHcount());
                    w.setW_cyFcount(CountUtil.getZount(hBaoJia.getHcount()));
                    w.setW_cyHcount(w.getW_cyZcount()+w.getW_cyFcount());
                    w.setW_cyYellow(hBaoJia.getHcyMs());
                    w.setW_cyYCount(CountUtil.getYinBanCount(hBaoJia.getHcyPs()));
                }

                w.setW_hjg(hBaoJia.getHfumo()+hBaoJia.getHh1()+hBaoJia.getHh2()+hBaoJia.getHh3()+hBaoJia.getHh4()+hBaoJia.getHh5()+hBaoJia.getHzd());
                w.setW_fmKs(hBaoJia.getHfmKs());
                w.setW_nxKs(hBaoJia.getHnxKs());
                w.setW_cyKs(hBaoJia.getHcyKs());
                w.setW_result(hBaoJia.gethResultMoney());
                w.setW_flag(flag1);
                break;
            case 2:
                SBaoJia sBaoJia = gson.fromJson(req.getParameter("BaoJia"), SBaoJia.class);
                flag=sBaoJia.getS_bjjl();
                w.setW_kDate(format);
                w.setW_jDate(format);

                w.setW_cName(sBaoJia.getS_cName());
                w.setW_pName(sBaoJia.getS_pName());
                w.setW_count(sBaoJia.getS_count());
                w.setW_cSize(sBaoJia.getS_cpSize());
                w.setW_pSize(sBaoJia.getS_cpSize());

                w.setW_fmPage(sBaoJia.getS_fmType());
                w.setW_fmKb(CountUtil.getKaiBie(sBaoJia.getS_cpSize())*2);
                w.setW_fmZcount(sBaoJia.getS_count());
                w.setW_fmFcount(CountUtil.getZount(sBaoJia.getS_count()));
                w.setW_fmHcount(w.getW_fmZcount()+w.getW_fmFcount());
                w.setW_fmYellow(sBaoJia.getS_fmMs());
                w.setW_fmYCount(CountUtil.getYinBanCount(sBaoJia.getS_fmPs()));

                w.setW_nxPage(sBaoJia.getS_nxType());
                w.setW_nxKb(CountUtil.getKaiBie(sBaoJia.getS_cpSize())*2);
                w.setW_nxZcount(sBaoJia.getS_count());
                w.setW_nxFcount(CountUtil.getZount(sBaoJia.getS_count()));
                w.setW_nxHcount(w.getW_nxZcount()+w.getW_nxFcount());
                w.setW_nxYellow(sBaoJia.getS_nxMs());
                w.setW_nxYCount(CountUtil.getYinBanCount(sBaoJia.getS_nxPs()));

                w.setW_cyPage(sBaoJia.getS_cyType());
                if (w.getW_cyPage()==""||w.getW_cyPage().equals("")){
                    w.setW_cyKb(0);
                    w.setW_cyZcount(0);
                    w.setW_cyFcount(0);
                    w.setW_cyHcount(0);
                    w.setW_cyYellow("");
                    w.setW_cyYCount(0);
                }else{
                    w.setW_cyKb(CountUtil.getKaiBie(sBaoJia.getS_cpSize())*2);
                    w.setW_cyZcount(sBaoJia.getS_count());
                    w.setW_cyFcount(CountUtil.getZount(sBaoJia.getS_count()));
                    w.setW_cyHcount(w.getW_cyZcount()+w.getW_cyFcount());
                    w.setW_cyYellow(sBaoJia.getS_cyMs());
                    w.setW_cyYCount(CountUtil.getYinBanCount(sBaoJia.getS_cyPs()));
                }

                w.setW_hjg(sBaoJia.getS_fumo()+sBaoJia.getS_h1()+sBaoJia.getS_h2()+sBaoJia.getS_h3()+sBaoJia.getS_h4()+sBaoJia.getS_h5()+sBaoJia.getS_zd());
                w.setW_fmKs(sBaoJia.getS_fmKs());
                w.setW_nxKs(sBaoJia.getS_nxKs());
                w.setW_cyKs(sBaoJia.getS_cyKs());
                w.setW_result(sBaoJia.getS_ResultMoney());
                w.setW_flag(flag1);
                break;
            case 3:
                break;
        }

        req.setAttribute("work",w);
        req.setAttribute("flag",flag);
        req.setAttribute("flag1",flag1);
        req.getRequestDispatcher("work.jsp").forward(req,resp);

    }

}
