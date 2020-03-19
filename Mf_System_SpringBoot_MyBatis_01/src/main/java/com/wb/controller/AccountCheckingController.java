package com.wb.controller;

import com.wb.pojo.PageInfo;
import com.wb.pojo.work.DuiZhang;
import com.wb.service.DuiZhangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/CheckAccount")
public class AccountCheckingController {
    @Autowired
    private DuiZhangService duiZhangService;
    @RequestMapping("/allAccount")
    public String allAccount(Model model){
        List<DuiZhang> duiZhangs = duiZhangService.selAll();
        for (DuiZhang d:duiZhangs){
            System.out.println(d);
        }
        model.addAttribute("list",duiZhangs);
        return "dzcx";
    }

    @RequestMapping("/specificAccount")
    public String specificAccount(String cName,Integer pageNum,Model model){
        PageInfo pageInfo=new PageInfo();
        int pageSize=10;
        if (pageNum==null){
            pageNum=1;
        }
        pageInfo.setPageSize(pageSize);
        pageInfo.setPageNumber(pageNum);
        pageInfo = duiZhangService.selBycName(pageInfo,cName);
        model.addAttribute("work",pageInfo);
        model.addAttribute("cName",cName);
        return  "dzwork";
    }
}
