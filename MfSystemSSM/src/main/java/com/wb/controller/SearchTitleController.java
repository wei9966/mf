package com.wb.controller;

import com.google.gson.Gson;
import com.wb.service.SearchTitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class SearchTitleController {
    @Autowired
    private SearchTitleService searchTitleService;
    @RequestMapping("/searchTitle")
    public void searchTitle(HttpServletRequest req, HttpServletResponse resp)throws IOException,ServletException {
            int type = Integer.valueOf(req.getParameter("type"));
            resp.setCharacterEncoding("utf-8");
            System.out.println("标题搜索"+type);
            switch (type){
                case 1:
                    searchTitleByCName(req,resp);
                    break ;
                case 2:
                    searchTitleByPName(req,resp);
                    break;
            }

    }
        private void searchTitleByPName(HttpServletRequest req, javax.servlet.http.HttpServletResponse resp) throws IOException,ServletException {
            List<String> list = searchTitleService.searchTitlePName();
            Gson g=new Gson();
            String s = g.toJson(list);
            System.out.println(s);
            resp.getWriter().write(s);
        }

        private void searchTitleByCName(HttpServletRequest req, javax.servlet.http.HttpServletResponse resp)throws IOException,ServletException {
            List<String> list = searchTitleService.searchTitleCName();
            Gson g=new Gson();
            String s = g.toJson(list);
            System.out.println(s);
            resp.getWriter().write(s);

        }

}
