package com.wb.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * 连接MyBatis工具包
 */
public class MyBatisUtil {
    private static InputStream is=null;
    private static SqlSessionFactory factory=null;
    private static ThreadLocal<SqlSession> tl=new ThreadLocal<>();
    static {
        try {
            is=Resources.getResourceAsStream("mybatis.xml");
            factory = new SqlSessionFactoryBuilder().build(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取session
     * @return
     */
    public static SqlSession getSession(){
        if (tl.get()==null){
            SqlSession session = factory.openSession();
            tl.set(session);
        }
        return tl.get();
    }
    /**
     * 关闭session
     */
    public static void closeSession(){
        SqlSession session = tl.get();
        if (session!=null)
        {
            session.close();
        }
        tl.set(null);

    }

}
