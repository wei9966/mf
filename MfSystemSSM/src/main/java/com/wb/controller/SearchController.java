package com.wb.controller;

import com.google.gson.Gson;
import com.wb.service.SearchService;
import com.wb.service.impl.SearchServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class SearchController {
    @Autowired
    private SearchService searchService;
    @RequestMapping("/search")
    public void search(HttpServletResponse resp, HttpServletRequest req) throws IOException,ServletException {
        int type = Integer.valueOf(req.getParameter("type"));
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
        List<String> list = searchService.searchCName(cName);
        String s = g.toJson(list);
        System.out.println(s);
        resp.getWriter().write(s);
    }

    private void searchJiTai(HttpServletRequest req, HttpServletResponse resp,SearchService ss)throws IOException,ServletException
    {
        Gson g=new Gson();
        String w_jiTai = req.getParameter("w_jiTai");
        List<String> list = searchService.searchJiTai(w_jiTai);
        String s = g.toJson(list);
        System.out.println(s);
        resp.getWriter().write(s);
    }
}
