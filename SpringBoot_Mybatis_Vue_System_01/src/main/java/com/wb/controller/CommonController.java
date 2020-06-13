package com.wb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Create By WeiBin on 2020/3/22 23:39
 */
@Controller
@RequestMapping("/")
public class CommonController {
    @RequestMapping("/{page}")
    public String show(@PathVariable String page){
        return page;
    }
}
