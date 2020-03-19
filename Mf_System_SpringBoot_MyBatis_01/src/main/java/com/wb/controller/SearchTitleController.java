package com.wb.controller;

import com.google.gson.Gson;
import com.wb.service.SearchTitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/searchTitle")
public class SearchTitleController {
    @Autowired
    private SearchTitleService searchTitleService;
    @Autowired
    private Gson g;
    @RequestMapping("/byCName")
    @ResponseBody
    public String searchTitleByCName(){
        List<String> list = searchTitleService.searchTitleCName();
        String s = g.toJson(list);
        System.out.println(s);
        return s;
    }

    @RequestMapping("/byPName")
    @ResponseBody
    public String searchTitleByPName(){
        List<String> list = searchTitleService.searchTitlePName();
        String s = g.toJson(list);
        System.out.println(s);
        return s;
    }

}
