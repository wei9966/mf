package com.wb.servlet;

import com.google.gson.Gson;
import com.wb.service.SearchTitleService;
import com.wb.service.impl.SearchTitleServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 标题搜索
 */
@WebServlet(name = "SearchTitleServlet",urlPatterns = "/searchTitle")
public class SearchTitleServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SearchTitleService sts=new SearchTitleServiceImpl();
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        int type = Integer.valueOf(req.getParameter("type"));

        System.out.println("标题搜索"+type);
        switch (type){
            case 1:
                searchTitleByCName(req,resp,sts);
               break ;
            case 2:
                searchTitleByPName(req,resp,sts);
                break;
        }


    }

    private void searchTitleByPName(HttpServletRequest req, HttpServletResponse resp, SearchTitleService sts) throws IOException,ServletException {
        List<String> list = sts.searchTitlePName();
        Gson g=new Gson();
        String s = g.toJson(list);
        System.out.println(s);
        resp.getWriter().write(s);
    }

    private void searchTitleByCName(HttpServletRequest req, HttpServletResponse resp, SearchTitleService sts)throws IOException,ServletException {
        List<String> list = sts.searchTitleCName();
        Gson g=new Gson();
        String s = g.toJson(list);
        System.out.println(s);
        resp.getWriter().write(s);

    }
}
