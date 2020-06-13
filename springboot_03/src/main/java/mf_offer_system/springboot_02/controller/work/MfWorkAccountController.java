package mf_offer_system.springboot_02.controller.work;

import mf_offer_system.springboot_02.service.MfWorkHbService;
import mf_offer_system.springboot_02.service.MfWorkService;
import mf_offer_system.springboot_02.util.ConstantUtil;
import mf_offer_system.springboot_02.util.PageUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Create By WeiBin on 2020/6/8 16:23
 *
 * @author WB
 */
@Controller
@RequestMapping("mfWorkAccount")
public class MfWorkAccountController {
    @Resource
    private MfWorkService mfWorkService;
    @Resource
    private MfWorkHbService mfWorkHbService;

    /**
     * 分页查询完整工单，根据用户和金额进行分组
     *
     * @param pageSize
     * @param currentPage
     * @param request
     * @return
     */
    @RequestMapping("/all/list")
    @ResponseBody
    public PageUtils allWorks(@RequestParam(defaultValue = "10", name = "pageSize") int pageSize,
                              @RequestParam(defaultValue = "1", name = "currentPage") int currentPage,
                              HttpServletRequest request) {
        System.out.println("当前页数" + currentPage + "分页数量" + currentPage);
        PageUtils pageUtils = null;
        if (ConstantUtil.USER_TYPE_COLOR.equals(request.getSession().getAttribute("user"))) {
            pageUtils = mfWorkService.queryByPageGroupByName(currentPage, pageSize);
        } else {
            pageUtils = mfWorkHbService.queryByPageGroupByName(currentPage, pageSize);
        }
        //计算出初始值
        return pageUtils;
    }

    /**
     * 分页查询完整工单
     *
     * @param pageSize
     * @param currentPage
     * @param request
     * @return
     */
    @RequestMapping("/single/list")
    @ResponseBody
    public PageUtils single(@RequestParam(defaultValue = "50", name = "pageSize") int pageSize,
                            @RequestParam(defaultValue = "1", name = "currentPage") int currentPage,
                            @RequestParam(name = "customerName") String customerName,
                            HttpServletRequest request) {
        PageUtils pageUtils = null;
        if (ConstantUtil.USER_TYPE_COLOR.equals(request.getSession().getAttribute("user"))) {
            pageUtils = mfWorkService.queryByPageByName(currentPage, pageSize, customerName);
        } else {
            pageUtils = mfWorkHbService.queryByPageByName(currentPage, pageSize, customerName);
        }
        //计算出初始值
        return pageUtils;
    }

}
