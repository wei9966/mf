package com.wb.filter;


import com.wb.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.*;
import java.io.IOException;

public class OpenSessionInView implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        SqlSession session = MybatisUtil.getSession();
        try {
            filterChain.doFilter(servletRequest,servletResponse);
            session.commit();
        } catch (Exception e) {
            session.rollback();
            e.printStackTrace();
        }finally {
            MybatisUtil.closeSession();
        }
    }

    @Override
    public void destroy() {

    }
}
