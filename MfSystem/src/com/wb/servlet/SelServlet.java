package com.wb.servlet;

import com.wb.dao.BaoJiaDao;
import com.wb.dao.impl.BaoJiaDaoImpl;
import com.wb.pojo.BaoJia;
import com.wb.pojo.PageInfo;
import com.wb.pojo.SBaoJia;
import com.wb.service.BaoJiaService;
import com.wb.service.impl.BaoJiaServiceImple;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SelServlet",urlPatterns = "/baoJiaSel")
public class SelServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int type = (Integer.valueOf(req.getParameter("type")));
        System.out.println("查询报价"+type);
        /**
         * 1 查询已生产和未生产的报价所有的报价单
         * 2 查询按钮点击进入的报价
         * 3 根据客户名称查询报价
         */
        switch (type){
            case 1:
                selBaoJia(req,resp);
                break;
            case 2:
                selJuTiBaoJia(req,resp);
                break;
            case 3:
                selJuTiBaoJiaByAny(req,resp);
                break;
        }

    }

    private void selJuTiBaoJiaByAny(HttpServletRequest req, HttpServletResponse resp)throws IOException,ServletException {

        int titleFlag=Integer.valueOf(req.getParameter("titleFlag"));
        BaoJiaDao b=new BaoJiaDaoImpl();
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
        /*1 代表客户名称
          2 代表印刷名称
*/
        switch (titleFlag){
            case 1:
                String cName = req.getParameter("cName");
                pa = b.selJuTiBaoJiaByCName(cName, pa);
                break;
            case 2:
                String pName = req.getParameter("pName");
                pa=b.selJuTiBaoJiaByPName(pName,pa);
                break;
        }
        req.setAttribute("page",pa);
        req.getRequestDispatcher("bj.jsp").forward(req,resp);

    }


    private void selJuTiBaoJia(HttpServletRequest req, HttpServletResponse resp)throws IOException,ServletException {
        BaoJiaService b=new BaoJiaServiceImple();
        String a = req.getParameter("id");
        int h = a.indexOf("h");
        int f = a.lastIndexOf("f");
        int id = Integer.valueOf(a.substring(h+1, f));
        int flag=Integer.valueOf(a.substring(f+1));
        Object o = b.selSingle(id, flag);
        switch (flag){
            case 1:
                BaoJia baojia=(BaoJia)o;
                System.out.println(baojia);
                req.setAttribute("baoJia",baojia);
                req.setAttribute("flag",flag);
                req.getRequestDispatcher("hcbjResult.jsp").forward(req,resp);
                break;
            case 2:
                SBaoJia sBaoJia=(SBaoJia) o;
                System.out.println(sBaoJia);
                req.setAttribute("baoJia",sBaoJia);
                req.setAttribute("flag",flag);
                req.getRequestDispatcher("skbjResult.jsp").forward(req,resp);
                break;
            case 3:
                break;
            case 4:
                break;
        }
    }

    private void selBaoJia(HttpServletRequest req, HttpServletResponse resp)throws IOException,ServletException {
        BaoJiaDao b=new BaoJiaDaoImpl();
        PageInfo pa=new PageInfo();
        int flag =3;
        String flagStr=req.getParameter("flag");
        /**
         * flag
         * 1 表示 未生产
         * 2 表示 已生产
         * 3 表示 全部
         */
        if (!(flagStr.equals("")||flagStr==null)){
            flag=Integer.valueOf(flagStr);
        }
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
        switch (flag){
            case 1:
                pa=  b.selProduceNo(pa);
                break;
            case 2:
                pa=  b.selProduceYes(pa);
                break;
            case 3:
                pa= b.selAll(pa);
                break;
        }
        req.setAttribute("page",pa);
        req.setAttribute("flag",flag);
        req.getRequestDispatcher("bj.jsp").forward(req,resp);
    }
}
