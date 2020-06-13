package mf_offer_system.springboot_02.controller.offer;

import mf_offer_system.springboot_02.entity.*;
import mf_offer_system.springboot_02.service.*;
import mf_offer_system.springboot_02.util.ConstantUtil;
import mf_offer_system.springboot_02.util.GetNowDate;
import mf_offer_system.springboot_02.util.JsonResult;
import mf_offer_system.springboot_02.util.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

/**
 * Create By WeiBin on 2020/5/9 22:00
 */
@Controller
@RequestMapping("/offer")
public class OfferController {

    @Autowired
    private MfOfferService mfOfferService;
    @Autowired
    private MfAmounService mfAmounService;
    @Autowired
    private MfBingdingService mfBingdingService;
    @Autowired
    private MfColorService mfColorService;
    @Autowired
    private MfTonpriceService mfTonpriceService;
    @Autowired
    private MfPaperService paperService;
    @Autowired
    private OfferService offerService;
    @Autowired
    private MfOfferBlackService mfOfferBlackService;
    @Resource
    private MfMachineService mfMachineService;
    @Autowired
    private MfCollageService mfCollageService;

    /**
     * 去到画册报价页面
     *
     * @param model 模型
     * @return 页面
     */
    @RequestMapping("/pictureAlbum/{typeId}")
    public String toPictureAlbumPage(Model model, @PathVariable("typeId") Integer typeId) {
        List<MfAmoun> mfAmouns = mfAmounService.queryAllByLimit(0, 10);
        List<MfBingding> mfBingdings = mfBingdingService.queryAllByLimit(0, 10);
        List<MfColor> mfColors = mfColorService.queryAllByLimit(0, 10);
        List<MfTonprice> mfTonprices = mfTonpriceService.queryAllByLimit(0, 10);
        List<MfPaper> mfPapers = paperService.queryAllByLimit(0, 10);
        model.addAttribute("mfAmouns", mfAmouns);
        model.addAttribute("mfPapers", mfPapers);
        model.addAttribute("mfBingdings", mfBingdings);
        model.addAttribute("mfColors", mfColors);
        model.addAttribute("mfTonprices", mfTonprices);
        if (typeId == 1) {
            return "offer/offer_picture_album";
        } else if (typeId == 2) {
            return "offer/offer_black_album";
        } else if (typeId == 3) {
            return "offer/offer_picture_single";
        } else if (typeId == 4) {
            return "offer/offer_black_single";
        } else {
            return null;
        }
    }

    /**
     * 报价的方法
     *
     * @param mfOffer 报价数据
     * @return 报价数据
     */
    @RequestMapping("/price/picture")
    @ResponseBody
    public MfOffer offerPrice(@RequestBody MfOffer mfOffer, HttpServletRequest request) {
        //计算画册价格 参数时mfOffer
        offerService.countPrice(mfOffer);
        //算出价格将价格注入这个对象并返回
        System.out.println(mfOffer);
        //获取当前时间并注入
        mfOffer.setOfferTime(GetNowDate.getNowDate());
        if (ConstantUtil.USER_TYPE_COLOR.equals(request.getSession().getAttribute("user"))) {
            mfOfferService.insert(mfOffer);
        } else {
            mfOfferBlackService.insert(mfOffer);
        }
        return mfOffer;
    }

    /**
     * 更新报价的方法
     *
     * @param mfOffer
     * @param request
     * @return
     */
    @RequestMapping("/price/picture/update")
    @ResponseBody
    public MfOffer offerPriceUpdate(@RequestBody MfOffer mfOffer, HttpServletRequest request) {
        //计算画册价格 参数时mfOffer
        offerService.countPrice(mfOffer);
        //算出价格将价格注入这个对象并返回
        System.out.println(mfOffer);
        if (ConstantUtil.USER_TYPE_COLOR.equals(request.getSession().getAttribute("user"))) {
            mfOfferService.update(mfOffer);
        } else {
            mfOfferBlackService.update(mfOffer);
        }
        return mfOffer;
    }

    /**
     * 显示所有报价的方法
     *
     * @param pageSize    每页显示的数量
     * @param currentPage 当前页数
     * @param request     请求
     * @return 分页的类
     */
    @RequestMapping("/all/list")
    @ResponseBody
    public PageUtils allOffers(@RequestParam(defaultValue = "50", name = "pageSize") int pageSize,
                               @RequestParam(defaultValue = "1", name = "currentPage") int currentPage,
                               HttpServletRequest request) {
        System.out.println("当前页数" + currentPage + "分页数量" + currentPage);
        PageUtils pageUtils = null;
        if (ConstantUtil.USER_TYPE_COLOR.equals(request.getSession().getAttribute("user"))) {
            pageUtils = mfOfferService.queryByPage(currentPage, pageSize);
        } else {
            pageUtils = mfOfferBlackService.queryByPage(currentPage, pageSize);
        }
        //计算出初始值
        return pageUtils;
    }

    /**
     * 去到报价结果页面
     *
     * @param offerId 报价id
     * @param
     * @param request 请求
     * @return 返回页面
     */
    @RequestMapping("/select/{offerId}")
    public ModelAndView selectOneOfferById(@PathVariable("offerId") Long offerId, HttpServletRequest request) {
        ModelAndView model = new ModelAndView();
        List<MfAmoun> mfAmouns = mfAmounService.queryAllByLimit(0, 10);
        List<MfBingding> mfBingdings = mfBingdingService.queryAllByLimit(0, 10);
        List<MfColor> mfColors = mfColorService.queryAllByLimit(0, 10);
        List<MfTonprice> mfTonprices = mfTonpriceService.queryAllByLimit(0, 10);
        List<MfPaper> mfPapers = paperService.queryAllByLimit(0, 10);
        model.addObject("mfAmouns", mfAmouns);
        model.addObject("mfPapers", mfPapers);
        model.addObject("mfBingdings", mfBingdings);
        model.addObject("mfColors", mfColors);
        model.addObject("mfTonprices", mfTonprices);
        model.addObject("offerId", offerId);
        model.setViewName("offer/offer_picture_album_result");
        return model;
    }

    /**
     * 显示报价结果
     *
     * @param offerId 报价id
     * @param request 请求
     * @return 返回报价单
     */
    @RequestMapping("/select/one/{offerId}")
    @ResponseBody
    public MfOffer selectOneOfferByOfferId(@PathVariable("offerId") Long offerId, HttpServletRequest request) {
        MfOffer mfOffer = null;
        if (ConstantUtil.USER_TYPE_COLOR.equals(request.getSession().getAttribute("user"))) {
            mfOffer = mfOfferService.queryOfferById(offerId);
        } else {
            mfOffer = mfOfferBlackService.queryOfferById(offerId);
        }
        return mfOffer;
    }

    /**
     * 跳转工单生产页面
     *
     * @return
     */
    @RequestMapping("/toWorkPage/{offerId}")
    public String toWorkPage(@PathVariable("offerId") Long offerId, Model model, HttpServletRequest request) {
        List<MfMachine> mfMachines = mfMachineService.queryAllByLimit(0, 10);
        List<MfCollage> mfCollages = mfCollageService.queryAllByLimit(0, 10);
        model.addAttribute("offerId", offerId);
        model.addAttribute("mfMachines", mfMachines);
        model.addAttribute("mfCollages", mfCollages);
        return "work/work_page";
    }

    @RequestMapping("/delete/offers")
    @ResponseBody
    public JsonResult deleteOffers(@RequestBody Long[] offers, HttpServletRequest request) {
        Arrays.asList(offers).forEach(integer -> System.out.print(integer + "\t"));
        boolean flag = false;
        if (ConstantUtil.USER_TYPE_COLOR.equals(request.getSession().getAttribute("user"))) {
            flag = mfOfferService.deleteByIds(offers);
        } else {
            flag = mfOfferBlackService.deleteByIds(offers);
        }
        if (flag) {
            return new JsonResult("200", "删除成功");
        }
        return new JsonResult("414", "删除失败");
    }

}
