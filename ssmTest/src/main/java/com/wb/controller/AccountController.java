package com.wb.controller;

import com.wb.domain.Account;
import com.wb.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 账户web
 */
@Controller
@RequestMapping("account")
public class AccountController {
//    注入业务层对象到controller
    @Autowired
    private AccountService accountService;

    /**
     *
     * @param model 存储对象
     * @return
     */
    @RequestMapping("findAll")
    public String findAll(Model model){
        System.out.println("表现层,查询所有账户");
//        调用service方法
//        能调用表面整合成功
        List<Account> list = accountService.findAll();
        model.addAttribute("list",list);
        return "list";
    }

    /**
     * 保存的方法
     * @return
     */
    @RequestMapping("/save")
    public void save(Account account, HttpServletRequest request, HttpServletResponse httpServletResponse) throws IOException {
    accountService.saveAccount(account);
    httpServletResponse.sendRedirect(request.getContextPath()+"/account/findAll");
    }
}
