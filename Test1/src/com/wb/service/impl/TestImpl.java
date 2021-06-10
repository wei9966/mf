package com.wb.service.impl;

import com.wb.mapper.TestMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class TestImpl implements TestMapper {
    @Override
    public List<String> selAll() {
        List<String> list=new ArrayList<>();
        try {
            InputStream is = Resources.getResourceAsStream("mybatis.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
            SqlSession session = factory.openSession();
            TestMapper mapper = session.getMapper(TestMapper.class);
            list = mapper.selAll();
            session.close();
            is.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;

    }
}
