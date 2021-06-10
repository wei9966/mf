package com.wb.servlet;

import com.wb.service.impl.TestImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Servlet",urlPatterns = "/tt")
public class Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TestImpl t=new TestImpl();
        List<String> list = t.selAll();
        String str="[";
        for (int i=0;i<list.size();i++){

            if (i<list.size()-1){
                str=str+"'"+list.get(i)+"',";
            }else{
                str=str+"'"+list.get(i)+"']";
            }
        }
        System.out.println(str);
        resp.setCharacterEncoding("utf-8");
        resp.getWriter().write(str);

    }
}
