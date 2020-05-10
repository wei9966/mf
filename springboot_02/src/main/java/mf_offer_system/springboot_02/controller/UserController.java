package mf_offer_system.springboot_02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Create By WeiBin on 2020/5/9 21:22
 *
 * @author WB
 */
@RequestMapping("/user")
@Controller
public class UserController {

    @RequestMapping("/person")
    public String toPersonPage() {
        return "user/user_index";
    }

    @RequestMapping("/offer")
    public String toOfferPage() {
        return "offer/offer_index";
    }

    @RequestMapping("/work")
    public String toWorkPage() {
        return "work/work_index";
    }

    @RequestMapping("/account")
    public String toAccountPage() {
        return "account/account_index";
    }

    @RequestMapping("/reconciliation")
    public String toReconciliationPage() {
        return "reconciliation/reconciliation_index";
    }

}
