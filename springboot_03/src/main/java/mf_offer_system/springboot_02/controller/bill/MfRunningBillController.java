package mf_offer_system.springboot_02.controller.bill;

import mf_offer_system.springboot_02.entity.MfRunningBill;
import mf_offer_system.springboot_02.service.MfRunningBillBlackService;
import mf_offer_system.springboot_02.service.MfRunningBillService;
import mf_offer_system.springboot_02.util.ConstantUtil;
import mf_offer_system.springboot_02.util.JsonResult;
import mf_offer_system.springboot_02.util.PageUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 明发流水表(MfRunningBill)表控制层
 *
 * @author makejava
 * @since 2020-05-28 11:47:14
 */
@RestController
@RequestMapping("bill")
public class MfRunningBillController {
    /**
     * 服务对象
     */
    @Resource
    private MfRunningBillService mfRunningBillService;
    @Resource
    private MfRunningBillBlackService mfRunningBillBlackService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public MfRunningBill selectOne(Integer id) {
        return this.mfRunningBillService.queryById(id);
    }

    @RequestMapping("/all/list")
    @ResponseBody
    public PageUtils allOffers(@RequestParam(defaultValue = "10", name = "pageSize") int pageSize,
                               @RequestParam(defaultValue = "1", name = "currentPage") int currentPage,
                               HttpServletRequest request) {
        System.out.println("当前页数" + currentPage + "分页数量" + currentPage);
        PageUtils pageUtils = null;
        if (ConstantUtil.USER_TYPE_COLOR.equals(request.getSession().getAttribute("user"))) {
            pageUtils = mfRunningBillService.queryByPage(currentPage, pageSize);
        } else {
            pageUtils = mfRunningBillBlackService.queryByPage(currentPage, pageSize);
        }
        return pageUtils;
    }

    @RequestMapping("/insert")
    public JsonResult insertBill(@RequestBody MfRunningBill mfRunningBill, HttpServletRequest request) {
        if (ConstantUtil.USER_TYPE_COLOR.equals(request.getSession().getAttribute("user"))) {
            mfRunningBillService.insert(mfRunningBill);
        } else {
            mfRunningBillBlackService.insert(mfRunningBill);
        }
        return new JsonResult("200", "添加成功");
    }

    @RequestMapping("/delete/{billId}")
    public JsonResult deleteBill(@PathVariable("billId") Integer billId, HttpServletRequest request) {
        boolean flag = false;
        if (ConstantUtil.USER_TYPE_COLOR.equals(request.getSession().getAttribute("user"))) {
            flag = mfRunningBillService.deleteById(billId);
        } else {
            flag = mfRunningBillBlackService.deleteById(billId);
        }
        if (flag) {
            return new JsonResult("200", "删除成功");
        }
        return new JsonResult("414", "删除失败");
    }

    @RequestMapping("/update")
    public JsonResult updateBill(@RequestBody MfRunningBill mfRunningBill, HttpServletRequest request) {
        if (ConstantUtil.USER_TYPE_COLOR.equals(request.getSession().getAttribute("user"))) {
            mfRunningBillService.update(mfRunningBill);
        } else {
            mfRunningBillBlackService.update(mfRunningBill);
        }
        return new JsonResult("200", "修改成功");
    }
}