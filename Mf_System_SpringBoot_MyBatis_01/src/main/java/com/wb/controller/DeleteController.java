package com.wb.controller;

import com.wb.service.DeleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Create By WeiBin on 2020/3/19 15:25
 */
@Controller
@RequestMapping("/delete")
public class DeleteController {

    @Autowired
    DeleteService deleteService;

    @RequestMapping("/hc")
    @ResponseBody
    public String  deleteHcBaoJia(Integer id,Integer hid){
        int i = deleteService.deleteBaoJiaHc(id, hid);
        if (i==2){
            return "删除成功";
        }else {
            return "删除失败";
        }
    }
}
