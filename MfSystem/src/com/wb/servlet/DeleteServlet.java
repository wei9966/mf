package com.wb.servlet;

import com.wb.service.DeleteService;
import com.wb.service.impl.DeleteServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DelectServlet",urlPatterns = "/delete")
public class DeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String flag = req.getParameter("flag");
        resp.setCharacterEncoding("utf-8");
        req.setCharacterEncoding("utf-8");
        //flag 1 是报价 2 是工单
        switch (flag){
            case "1":
                deleteBaoJia(req,resp);
                break;
            case "2":
                break;

        }


    }

    private void deleteBaoJia(HttpServletRequest req, HttpServletResponse resp) throws IOException,ServletException {
        String flagType = req.getParameter("flagType");
        DeleteService ds=new DeleteServiceImpl();
//        flagType  1 代表画册 2 是书刊
        switch (flagType){
            case "1":
                deleteBaoJiaHc(req,resp,ds);
                break;
            case "2":
                deleteBaoJiaSk(req,resp,ds);
                break;
            case "3":
                break;
        }


    }

    /**
     * 删除书刊报价记录
     * @param req
     * @param resp
     * @param ds
     * @throws IOException
     * @throws ServletException
     */
    private void deleteBaoJiaSk(HttpServletRequest req, HttpServletResponse resp, DeleteService ds)throws IOException,ServletException {
        int id = Integer.valueOf(req.getParameter("id"));
        int hid=Integer.valueOf(req.getParameter("hid"));
//        id 代表 具体报价id
//        hid代表报价记录id
        int f= ds.deleteBaoJiaSk(id,hid);
        if (f>1){
            resp.getWriter().write("删除成功");
        }else {
            resp.getWriter().write("删除失败，请重试");
        }


    }

    /**
     *
     * 删除报价画册记录
     * @param req
     * @param resp
     */
    private void deleteBaoJiaHc(HttpServletRequest req, HttpServletResponse resp,DeleteService des)throws IOException {
        int id = Integer.valueOf(req.getParameter("id"));
        int hid=Integer.valueOf(req.getParameter("hid"));
//        id 代表 具体报价id
//        hid代表报价记录id
       int f= des.deleteBaoJiaHc(id,hid);
       if (f>1){
           resp.getWriter().write("删除成功");
       }else {
           resp.getWriter().write("删除失败，请重试");
       }
    }
}
