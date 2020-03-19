package com.wb.controller;

import com.google.gson.Gson;
import com.wb.pojo.PageInfo;
import com.wb.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/search")
public class SearchController {
    @Autowired
    private  SearchService searchService;
    @Autowired
    private  Gson g;
    @RequestMapping("/searchCName")
    @ResponseBody
    public String searchCName(String cName){
        List<String> list = searchService.searchCName(cName);
        System.out.println(cName);
        String s = g.toJson(list);
        System.out.println(s);
        return s;
    }
    @RequestMapping("/searchJiTai")
    @ResponseBody
    public String searchJiTai(String w_jiTai){
        List<String> list = searchService.searchJiTai(w_jiTai);
        String s = g.toJson(list);
        System.out.println(s);
        return s;
    }
    @RequestMapping("/searchBaoJiaByAny")
    public String searchBaoJiaByAny(String cName, String pName, Integer pageNum, Model model,Integer flag){
        PageInfo pa=new PageInfo();
        if (pageNum==null){
            pageNum=1;
        }
        int pageSize=10;
        pa.setPageNumber(pageNum);
        pa.setPageSize(pageSize);
         pa = searchService.searchBaoJiaByAny(pa, cName, pName);
        System.out.println(flag);
        model.addAttribute("page",pa);
        model.addAttribute("flag",flag);
        model.addAttribute("cName",cName);
        model.addAttribute("pName",pName);
        return "bj";
    }
}
