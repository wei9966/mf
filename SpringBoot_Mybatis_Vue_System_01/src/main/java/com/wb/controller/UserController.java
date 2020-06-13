package com.wb.controller;

import com.wb.pojo.JsonResult;
import com.wb.pojo.User;
import com.wb.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Create By WeiBin on 2020/3/22 23:38
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
   private UserService userService;

    @PostMapping("/login")
    public JsonResult userLogin(@RequestParam("username")String username,@RequestParam("password") String password){
        System.out.println(username+"\t"+password);
       User user = userService.VerifitUser(username, password);
        if (user!=null){
            return new JsonResult(200,"验证通过",user);
        }else {
            return new JsonResult(400,"用户名密码错误");
        }
    }
}
