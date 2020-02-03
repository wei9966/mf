package com.wb.servlet;

import com.google.gson.Gson;
import com.wb.service.SearchService;
import com.wb.service.impl.SearchServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SerachSevlet",urlPatterns = "/search")
public class SerachSevlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int type = Integer.valueOf(req.getParameter("type"));
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        System.out.println("搜索类型"+type);
        SearchService ss=new SearchServiceImpl();
        /**
         * 1 机台
         * 2 客户名称
         *
         */
        switch (type){
            case 1:
                searchJiTai(req,resp,ss);
                break;
            case 2:
                searchCName(req,resp,ss);
                break;

        }

    }

    private void searchCName(HttpServletRequest req, HttpServletResponse resp, SearchService ss)throws IOException,ServletException {
        Gson g=new Gson();
        String cName = req.getParameter("cName");
        List<String> list = ss.searchCName(cName);
        String s = g.toJson(list);
        System.out.println(s);
        resp.getWriter().write(s);
    }

    private void searchJiTai(HttpServletRequest req, HttpServletResponse resp,SearchService ss)throws IOException,ServletException
    {
        Gson g=new Gson();
        String w_jiTai = req.getParameter("w_jiTai");
        List<String> list = ss.searchJiTai(w_jiTai);
            String s = g.toJson(list);
            System.out.println(s);
            resp.getWriter().write(s);
    }
}
