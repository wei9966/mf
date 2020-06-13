package com.wb.test;

import com.wb.dao.AccountDao;
import com.wb.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMybatis {
    /**
     *
     * 测试查询
     * @throws IOException
     */
    @Test
    public void run1() throws IOException {
//        加载mybatis的配置文件
        InputStream is = Resources.getResourceAsStream("mybatis.xml");
//        创建sqlSessionFactory
//        构建者的模式
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(is);
//        创建sqlSession
        SqlSession session = build.openSession();
//        获取代理对象
        AccountDao ad = session.getMapper(AccountDao.class);
        List<Account> all = ad.findAll();
        for (Account account:all){
            System.out.println(account);
        }
//        关闭资源
        session.close();
        is.close();
    }
//    测试报错
    @Test
    public void run2() throws IOException{
        Account account=new Account();
        //        加载mybatis的配置文件
        InputStream is = Resources.getResourceAsStream("mybatis.xml");
//        创建sqlSessionFactory
//        构建者的模式
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(is);
//        创建sqlSession
        SqlSession session = build.openSession();
//        获取代理对象
        AccountDao ad = session.getMapper(AccountDao.class);
        account.setMoney(500d);
        account.setName("张三");
        ad.saveAccount(account);
//        提交事务
        session.commit();
        //        关闭资源
        session.close();
        is.close();

    }
}
