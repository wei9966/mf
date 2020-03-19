package com.wb.test;

import com.wb.pojo.PageInfo;
import com.wb.service.BaoJiaService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Test {

  private   ApplicationContext bc= new ClassPathXmlApplicationContext("bean.xml");
  private BaoJiaService bs= bc.getBean("BaoJiaService",BaoJiaService.class);
  @org.junit.Test
  public void testFindAll() {
//        执行方法
    PageInfo pa=new PageInfo();
    pa.setPageNumber(1);
    pa.setPageSize(5);
    PageInfo pageInfo = bs.selAll(pa);
    List<?> list = pageInfo.getList();
    System.out.println(list);
  }

}
