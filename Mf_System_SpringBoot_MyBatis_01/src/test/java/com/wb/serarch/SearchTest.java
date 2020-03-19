package com.wb.serarch;

import com.wb.Application;
import com.wb.pojo.PageInfo;
import com.wb.service.SearchService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class SearchTest {
    @Autowired
    private  SearchService searchService;
    @Test
    public void test(){
        String siez=null;
        PageInfo p=new PageInfo();
        p.setPageNumber(1);
        p.setPageSize(5);
        PageInfo pageInfo = searchService.searchBaoJiaByAny(p, "从" ,"");
        for (int i=0;i<pageInfo.getList().size();i++){
            System.out.println(pageInfo.getList().get(i));
        }

    }
}
