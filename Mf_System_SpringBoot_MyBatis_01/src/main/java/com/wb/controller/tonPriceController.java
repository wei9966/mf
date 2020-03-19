package com.wb.controller;

import com.wb.pojo.DunJia;
import com.wb.service.DunJiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 吨价显示和设置控制器
 */
@Controller
@RequestMapping("/ton")
public class tonPriceController {
    @Autowired
    private DunJiaService dunJiaService;
    @RequestMapping("/showTonPrice")
    public String showTonPrice(Model model){
        List<DunJia> dunJia = dunJiaService.getDunJia();
        model.addAttribute("dunJia",dunJia);
        return "dj";
    }
    @RequestMapping(value = "/updateTonPrice")
    @ResponseBody
    public String updateTonPrice(Integer price,String id){
        int d = Integer.valueOf(id.substring(id.indexOf("d") + 1));
        DunJia dunJia1=new DunJia();
        dunJia1.setId(d);
        dunJia1.setPrice(price);
        dunJiaService.updateDJ(dunJia1);
        return "修改成功";
    }
}
