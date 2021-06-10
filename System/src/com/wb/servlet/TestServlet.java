package com.wb.servlet;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.wb.pojo.Gpojo;
import com.wb.pojo.Result;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "TestServlet",urlPatterns = "/price")
public class TestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String oo = req.getParameter("oo");
        Map map = JSON.parseObject(oo, Map.class);
        Gpojo g=new Gpojo();
        String fengMian = String.valueOf(map.get("fengMian"));
        Integer fmKs = Integer.valueOf(String.valueOf(map.get("fmKs")));
        Integer fmPs = Integer.valueOf(String.valueOf(map.get("fmPs")));
        String cpSize = String.valueOf(map.get("cpSize"));
        Integer count = Integer.valueOf(String.valueOf(map.get("count")));
        String neiXin = String.valueOf(map.get("neiXin"));
        Integer nxKs = Integer.valueOf(String.valueOf(map.get("nxKs")));
        Integer nxPs = Integer.valueOf(String.valueOf(map.get("nxPs")));
        String fumo = String.valueOf(map.get("fumo"));
        String zd = String.valueOf(map.get("zd"));
        String sType = String.valueOf(map.get("sType"));
        Double hv1 = Double.valueOf(String.valueOf(map.get("hv1")));
        Double hv2 = Double.valueOf(String.valueOf(map.get("hv2")));
        Double hv3 = Double.valueOf(String.valueOf(map.get("hv3")));
        g.setcName( String.valueOf(map.get("cName")));
        g.setpName(String.valueOf(map.get("pName")));
        g.setCount(count);
        g.setFengMian(fengMian);
        g.setFmKs(fmKs);
        g.setFmPs(fmPs);
        g.setCpSize(cpSize);
        g.setNeiXin(neiXin);
        g.setNxKs(nxKs);
        g.setNxPs(nxPs);
        g.setFumo(fumo);
        g.setZd(zd);
        g.setsType(sType);
        g.setHv1(hv1);
        g.setHv2(hv2);
        g.setHv3(hv3);
        System.out.println(g);
        Gson gson = new Gson();
        Result r=new Result();
        r.setFmResult(200);
        r.setHjgResult(200);
        r.setNxResult(200);
        r.setPsResult(20);
        r.setResultMoney(3000);
        String s = gson.toJson(r);
        System.out.println(s);
        resp.getWriter().write(gson.toJson(r));
    }
}
