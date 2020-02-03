package com.wb.servlet;

import com.wb.pojo.PageInfo;
import com.wb.service.OrderByAnyService;
import com.wb.service.impl.OrderByAnyServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 排序
 */
@WebServlet(name = "OrderByAnyServlet", urlPatterns = "/order")
public class OrderByAnyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int flag = Integer.valueOf(req.getParameter("flag"));
        OrderByAnyService obas=new OrderByAnyServiceImpl();
        System.out.println("排序" + flag);
        /**flag
         * 1 代表日期
         *          * 2代表成品数量
         *          * 3代表总金额
         *
         */

        switch (flag) {
            case 1:
                orderByDate(req,resp,obas);
                break;
            case 2:
                break;
            case 3:
                break;
        }
    }

    private void orderByDate(HttpServletRequest req, HttpServletResponse resp, OrderByAnyService obas) {
        /**
         value
         *  1 代表未生产
         *  2 代表已生产
         *  3 代表全部
         */
        Integer value = Integer.valueOf(req.getParameter("value"));
        System.out.println("生产状态"+value);
        PageInfo pa=new PageInfo();
        String pageNumStr = req.getParameter("pageNum");
        int pageNum=1;
        if (pageNumStr==null||pageNumStr.equals("")){
        }else {
            if (!pageNumStr.equals("1")){
                pageNum=Integer.valueOf(pageNumStr);
            }
        }
        int pageSize=10;
        pa.setPageNumber(pageNum);
        pa.setPageSize(pageSize);
        switch (value){
            case 1:

                break;
            case 2:

                break;
            case 3:

                break;
        }


    }
}
