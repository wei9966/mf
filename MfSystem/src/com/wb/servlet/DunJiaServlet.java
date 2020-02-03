package com.wb.servlet;

import com.wb.pojo.DunJia;
import com.wb.service.DunJiaService;
import com.wb.service.impl.DunJiaServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 吨价设置
 */
@WebServlet(name = "DunJiaServlet",urlPatterns = "/dunJia")
public class DunJiaServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int type = (Integer.valueOf(req.getParameter("type")));
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        DunJiaService dunJia=new DunJiaServiceImpl();
        /**
         * 1 查询吨价
         * 2 更新吨价
         */
        switch (type){
            case 1:
                Sel(req,resp,dunJia);
                break;
            case 2:
                UpdateDunJia(req,resp,dunJia);
                break;
            case 3:

                break;
        }

    }

    private void UpdateDunJia(HttpServletRequest req, HttpServletResponse resp, DunJiaService dunJia)throws IOException,ServletException {
        int price = Integer.valueOf(req.getParameter("price"));
        String id = req.getParameter("id");
        int d = Integer.valueOf(id.substring(id.indexOf("d") + 1));
        DunJia dunJia1=new DunJia();
        dunJia1.setId(d);
        dunJia1.setPrice(price);
        int i = dunJia.updateDJ(dunJia1);
        req.getRequestDispatcher("dunJia?type=1").forward(req,resp);
    }


    private void Sel(HttpServletRequest req, HttpServletResponse resp, DunJiaService dunJia)throws IOException,ServletException {
        List<DunJia> dunJia1 = dunJia.getDunJia();
        req.setAttribute("dunJia",dunJia1);
        req.getRequestDispatcher("dj.jsp").forward(req,resp);
    }

}
