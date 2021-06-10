package com.wb.servlet;

import com.google.gson.Gson;
import com.wb.pojo.Gpojo;
import com.wb.pojo.Result;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "TestServlet1",urlPatterns = "/test")
public class TestServlet1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String oo = req.getParameter("oo");
        Gson gson = new Gson();
        Gpojo g=gson.fromJson(oo,Gpojo.class);
        System.out.println(g);
        Result r=new Result();
        r.setFmResult(200);
        r.setHjgResult(200);
        r.setNxResult(200);
        r.setPsResult(20);
        r.setResultMoney(3000);
        String s = gson.toJson(r);
        System.out.println(s);
        resp.getWriter().write(s);



    }
}
