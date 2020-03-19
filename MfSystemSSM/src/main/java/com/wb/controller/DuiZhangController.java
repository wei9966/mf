package com.wb.controller;

import com.wb.pojo.PageInfo;
import com.wb.pojo.work.DuiZhang;
import com.wb.service.DuiZhangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller

public class DuiZhangController {
    @Autowired
    private DuiZhangService duiZhangService;
        @RequestMapping("/duiZhang")
    public void DuiZhang(HttpServletRequest req, HttpServletResponse resp)throws IOException,ServletException {
        resp.setCharacterEncoding("utf-8");
            Integer type = Integer.valueOf(req.getParameter("type"));
            System.out.println("对账类型"+type);
            switch (type){
                case 1:
                    selAll(req,resp);
                    break;
                case 2:
                    selBycName(req,resp);
                    break;
            }
        }

    private void selBycName(HttpServletRequest req, HttpServletResponse resp)throws IOException,ServletException {
        String cName = req.getParameter("cName");
        PageInfo pageInfo=new PageInfo();
        int pageSize=10;
        int pageNum=1;
        String pageNumStr = req.getParameter("pageNum");
        if (!(pageNumStr==null||pageNumStr.equals(""))){
            pageNum=Integer.valueOf(pageNumStr);
        }
        pageInfo.setPageSize(pageSize);
        pageInfo.setPageNumber(pageNum);
         pageInfo = duiZhangService.selBycName(pageInfo,cName);
         req.setAttribute("work",pageInfo);
         req.setAttribute("cName",cName);
         req.getRequestDispatcher("dzwork.jsp").forward(req,resp);
    }

    private void selAll(HttpServletRequest req, HttpServletResponse resp) throws IOException,ServletException{
        List<DuiZhang> duiZhangs = duiZhangService.selAll();
        for (DuiZhang d:duiZhangs){
            System.out.println(d);
        }
        req.setAttribute("list",duiZhangs);
        req.getRequestDispatcher("dzcx.jsp").forward(req,resp);
    }
}
