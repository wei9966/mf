package com.wb.controller;

import com.google.gson.Gson;
import com.wb.pojo.BaoJia;
import com.wb.pojo.PageInfo;
import com.wb.pojo.SBaoJia;
import com.wb.service.BaoJiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/baoJiaSel")
public class BaoJiaSelController {
    @Autowired
    private BaoJiaService baoJiaService;
    @Autowired
    private Gson g;
    @RequestMapping("/quote")
    public String selBaoJia(Integer type, Integer flag, Integer pageNum,Model model,String cName,String pName){
        System.out.println(type+"\t"+flag);
        String str="";
        switch (type){
            case 1:
                str= selectQuote(flag,pageNum,model,cName,pName);
                break;
        }
        return str;
    }

    private String selectQuote(Integer flag,Integer pageNum,Model model,String cName,String pName) {
        PageInfo pa=new PageInfo();
        System.out.println("页数"+pageNum);
        if (pageNum==null){
            pageNum=1;
        }else {
        }
        int pageSize=10;
        pa.setPageNumber(pageNum);
        pa.setPageSize(pageSize);
        switch (flag){
            case 1:
                pa=  baoJiaService.selProduceNo(pa,cName,pName);
                break;
            case 2:
                pa=  baoJiaService.selProduceYes(pa,cName,pName);
                break;
            case 3:
                pa= baoJiaService.selAll(pa,cName,pName);
                break;
        }
        model.addAttribute("page",pa);
        model.addAttribute("flag",flag);
        return "bj";
    }

    @RequestMapping("/specific")
    public String selSpecificQuote(String id,Model model){
        int h = id.indexOf("h");
        int f = id.lastIndexOf("f");
        int id1 = Integer.valueOf(id.substring(h+1, f));
        int flag=Integer.valueOf(id.substring(f+1));
        Object o = baoJiaService.selSingle(id1, flag);
        String page="";
        switch (flag){
            case 1:
                BaoJia baojia=(BaoJia)o;
                model.addAttribute("baoJia",baojia);
                model.addAttribute("flag",flag);
                String s = g.toJson(baojia);
                model.addAttribute("jsonBaoJia",s);
                page="hcbjResult";
                break;
            case 2:
                SBaoJia sBaoJia=(SBaoJia) o;
                String s1 = g.toJson(sBaoJia);
                model.addAttribute("baoJia",sBaoJia);
                System.out.println(sBaoJia);
                model.addAttribute("flag",flag);
                model.addAttribute("jsonBaoJia",s1);
                page="skbjResult";
                break;
            case 3:
                break;
            case 4:
                break;
        }
        return page;
    }

}
