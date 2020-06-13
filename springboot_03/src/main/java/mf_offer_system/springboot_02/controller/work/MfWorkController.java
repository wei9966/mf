package mf_offer_system.springboot_02.controller.work;

import mf_offer_system.springboot_02.entity.MfOffer;
import mf_offer_system.springboot_02.entity.MfWork;
import mf_offer_system.springboot_02.service.*;
import mf_offer_system.springboot_02.util.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 工单表(MfWork)表控制层
 *
 * @author makejava
 * @since 2020-05-13 11:56:43
 */
@Controller
@RequestMapping("mfWork")
public class MfWorkController {
    /**
     * 服务对象
     */
    @Resource
    private MfWorkService mfWorkService;
    @Resource
    private MfOfferService mfOfferService;
    @Resource
    private MfOfferBlackService mfOfferBlackService;
    @Resource
    private MfWorkHbService mfWorkHbService;
    @Resource
    private MfPaperService mfPaperService;
    @Resource
    private MfMachineService mfMachineService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public MfWork selectOne(Long id) {
        return this.mfWorkService.queryById(id);
    }

    /**
     * 初始化工单  从报价页面过来的
     *
     * @param offerId 报价单id
     * @return 初始化后的工单
     */
    @RequestMapping("/getInitWork/{offerId}")
    @ResponseBody
    public MfWork getInitWork(@PathVariable("offerId") Long offerId, HttpServletRequest request) {
        MfWork work = new MfWork();
        MfOffer mfOffer = null;
        if (ConstantUtil.USER_TYPE_COLOR.equals(request.getSession().getAttribute("user"))) {
            mfOffer = mfOfferService.queryOfferById(offerId);
        } else {
            mfOffer = mfOfferBlackService.queryOfferById(offerId);
        }
        //注入id
        work.setWorkOfferId(offerId);
        //注入时间
        work.setWorkTime(GetNowDate.getNowDate());
        //注入尺寸
        work.setWorkCustomerName(mfOffer.getOfferCustomerName());
        work.setWorkProductName(mfOffer.getOfferProductName());
        //注入数量
        work.setWorkNumber(mfOffer.getOfferNumber());
        //注入尺寸
        work.setProductSizeId(mfOffer.getSizeId());
        work.setProductSizeType(mfOffer.getSizeType());
        //注入开别
        int kaiBie = mfPaperService.getKaiBie(mfOffer.getSizeId()) * 2;
        if (mfOffer.getTypeId() == 1 || mfOffer.getTypeId() == 2) {
            //纸型
            work.setCorePaperId(mfOffer.getPaperIdCore());
            work.setCorePaperType(mfOffer.getPaperCoreType());
            work.setCoverPaperId(mfOffer.getPaperIdCover());
            work.setCoverPaperType(mfOffer.getPaperCoverType());
            //注入克数
            work.setWorkCoverGrammage(mfOffer.getOfferCoverGrammage());
            work.setWorkCoreGrammage(mfOffer.getOfferCoreGrammage());
            //注入放数
            work.setWorkCoverPlayNumber(GetPlayNumber.getPlayNumber(mfOffer.getOfferNumber(), 1));
            work.setWorkCorePlayNumber(GetPlayNumber.getPlayNumber(mfOffer.getOfferNumber(), 1));
            //注入贴数
            work.setCoverPostsNumber(CountUtil.getPostsNumber(mfOffer.getOfferCoverP(), mfPaperService.getKaiBie(mfOffer.getSizeId())));
            work.setCorePostsNumber(CountUtil.getPostsNumber(mfOffer.getOfferCoreP(), mfPaperService.getKaiBie(mfOffer.getSizeId())));
            //合全开数算法不对
            work.setWorkCoverAlloysNumber(CountUtil.getPaperNumber(mfOffer.getOfferCoverP(), mfPaperService.getKaiBie(mfOffer.getSizeId()), mfOffer.getOfferNumber(), 1));
            work.setWorkCoreAlloysNumber(CountUtil.getPaperNumber(mfOffer.getOfferCoreP(), mfPaperService.getKaiBie(mfOffer.getSizeId()), mfOffer.getOfferNumber(), 1));
            work.setWorkCoverLeave(kaiBie);
            work.setWorkCoreLeave(kaiBie);
            //注入拼版数量
            work.setCoverColorId(mfOffer.getColorIdCover());
            work.setCoverColorType(mfOffer.getCoverColorType());
            work.setCoreColorId(mfOffer.getColorIdCore());
            work.setCoreColorType(mfOffer.getCoreColorType());
        } else if (mfOffer.getTypeId() == 3 || mfOffer.getTypeId() == 4) {
            //只要注入内芯的内容即可
            work.setCoverPaperId(mfOffer.getPaperIdCover());
            work.setCorePaperType(mfOffer.getPaperCoreType());
            work.setWorkCoreGrammage(mfOffer.getOfferCoreGrammage());
            work.setWorkCorePlayNumber(GetPlayNumber.getPlayNumber(mfOffer.getOfferNumber(), 1));
            //贴数
            work.setCorePostsNumber(CountUtil.getPostsNumber(mfOffer.getOfferCoreP(), mfPaperService.getKaiBie(mfOffer.getSizeId())));
            //合全开数
            work.setWorkCoreAlloysNumber(CountUtil.getPaperNumber(mfOffer.getOfferCoreP(), mfPaperService.getKaiBie(mfOffer.getSizeId()), mfOffer.getOfferNumber(), 1));
            work.setWorkCoreLeave(kaiBie);
            //注入拼版数量
            work.setCoreColorId(mfOffer.getColorIdCore());
            work.setCoreColorType(mfOffer.getCoreColorType());
        }
        //如果插页不为空,注入插页的一些值
        if (mfOffer.getOfferInsetGrammage() != null) {
            //纸型
            work.setInsetPaperId(mfOffer.getPaperIdInset());
            work.setInsetPaperType(mfOffer.getPaperInsetType());
            //开别
            work.setWorkInsetLeave(kaiBie);
            //墨色
            work.setInsetColorId(mfOffer.getColorIdInset());
            work.setInsetColorType(mfOffer.getInsetColorType());
            //注入贴数
            work.setInsetPostsNumber(CountUtil.getPostsNumber(mfOffer.getOfferInsetP(), mfPaperService.getKaiBie(mfOffer.getSizeId())));
            //克数
            work.setWorkInsetGrammage(mfOffer.getOfferInsetGrammage());
            //放数
            work.setWorkInsetPlayNumber(GetPlayNumber.getPlayNumber(mfOffer.getOfferNumber(), 1));
            //合全开数
            work.setWorkInsetAlloysNumber(CountUtil.getPaperNumber(mfOffer.getOfferInsetP(), mfPaperService.getKaiBie(mfOffer.getSizeId()), mfOffer.getOfferNumber(), 1));
        }
        StringBuffer postProcess = new StringBuffer();
        if (mfOffer.getAmounId() != null) {
            postProcess.append(mfOffer.getAmounType() + "|");
        }
        if (mfOffer.getBindingId() != null) {
            postProcess.append(mfOffer.getBindingType() + "|");
        }
        if (mfOffer.getOfferProcess1Price() != 0) {
            postProcess.append(mfOffer.getOfferProcess1Name() + "|");
        }
        if (mfOffer.getOfferProcess2Price() != 0) {
            postProcess.append(mfOffer.getOfferProcess2Name() + "|");
        }
        if (mfOffer.getOfferProcess3Price() != 0) {
            postProcess.append(mfOffer.getOfferProcess3Name() + "|");
        }
        if (mfOffer.getOfferProcess4Price() != 0) {
            postProcess.append(mfOffer.getOfferProcess4Name() + "|");
        }
        if (mfOffer.getOfferProcess5Price() != 0) {
            postProcess.append(mfOffer.getOfferProcess5Name() + "|");
        }
        //注入价格
        work.setWorkCoverPrice(mfOffer.getOfferCoverPrive());
        work.setWorkCorePrice(mfOffer.getOfferCorePrice());
        work.setWorkPostProcessPrice(mfOffer.getOfferMachiningPrice());
        work.setWorkTotalPrice(mfOffer.getOfferTotalPrice());
        work.setWorkPostProcessing(postProcess.toString());
        return work;
    }

    /**
     * 用来实行生产功能
     *
     * @param mfWork  前端传过来的初始化的工单
     * @param offerId 报价单id  用来更新生产状态
     * @param request 请求
     * @return json格式的是否添加成功
     */
    @RequestMapping("/produce/{offerId}")
    @ResponseBody
    public JsonResult produceWork(@RequestBody MfWork mfWork, @PathVariable("offerId") Long offerId, HttpServletRequest request) {
        MfOffer mfOffer = new MfOffer();
        mfOffer.setOfferId(offerId);
        mfOffer.setOfferProduceId(1);

        //添加之前先进行增加我们的印版数量

        //用来判断这个工单是否被注册
        Integer flag = null;
        if (ConstantUtil.USER_TYPE_COLOR.equals(request.getSession().getAttribute("user"))) {
            MfOffer mfOffer1 = mfOfferService.queryOfferById(offerId);
            if (mfOffer1.getTypeId() == 1 || mfOffer1.getTypeId() == 2) {
                mfWork.setWorkCoverLeave(CountUtil.getLeaveNum(mfOfferService.queryOfferById(mfWork.getWorkOfferId()).getOfferCoverP(), mfPaperService.getKaiBie(mfWork.getProductSizeId()), mfMachineService.queryById(mfWork.getMachineId()).getMachineType()));
                mfWork.setWorkCoreLeave(CountUtil.getLeaveNum(mfOfferService.queryOfferById(mfWork.getWorkOfferId()).getOfferCoreP(), mfPaperService.getKaiBie(mfWork.getProductSizeId()), mfMachineService.queryById(mfWork.getMachineId()).getMachineType()));
            }
            mfWork.setWorkCoreLeave(CountUtil.getLeaveNum(mfOfferService.queryOfferById(mfWork.getWorkOfferId()).getOfferCoreP(), mfPaperService.getKaiBie(mfWork.getProductSizeId()), mfMachineService.queryById(mfWork.getMachineId()).getMachineType()));
            if (mfWork.getWorkInsetGrammage() != null) {
                mfWork.setWorkInsetLeave(CountUtil.getLeaveNum(mfOfferService.queryOfferById(mfWork.getWorkOfferId()).getOfferInsetP(), mfPaperService.getKaiBie(mfWork.getProductSizeId()), mfMachineService.queryById(mfWork.getMachineId()).getMachineType()));
            }
            flag = mfWorkService.insertMfWork(mfWork, mfOffer);
        } else {
            MfOffer mfOffer11 = mfOfferBlackService.queryOfferById(offerId);
            if (mfOffer11.getTypeId() == 1 || mfOffer11.getTypeId() == 2) {
                mfWork.setWorkCoverLeave(CountUtil.getLeaveNum(mfOfferBlackService.queryOfferById(mfWork.getWorkOfferId()).getOfferCoverP(), mfPaperService.getKaiBie(mfWork.getProductSizeId()), mfMachineService.queryById(mfWork.getMachineId()).getMachineType()));
                mfWork.setWorkCoreLeave(CountUtil.getLeaveNum(mfOfferBlackService.queryOfferById(mfWork.getWorkOfferId()).getOfferCoreP(), mfPaperService.getKaiBie(mfWork.getProductSizeId()), mfMachineService.queryById(mfWork.getMachineId()).getMachineType()));
            }
            mfWork.setWorkCoreLeave(CountUtil.getLeaveNum(mfOfferBlackService.queryOfferById(mfWork.getWorkOfferId()).getOfferCoreP(), mfPaperService.getKaiBie(mfWork.getProductSizeId()), mfMachineService.queryById(mfWork.getMachineId()).getMachineType()));
            if (mfWork.getWorkInsetGrammage() != null) {
                mfWork.setWorkInsetLeave(CountUtil.getLeaveNum(mfOfferBlackService.queryOfferById(mfWork.getWorkOfferId()).getOfferInsetP(), mfPaperService.getKaiBie(mfWork.getProductSizeId()), mfMachineService.queryById(mfWork.getMachineId()).getMachineType()));
            }
            flag = mfWorkHbService.insertMfWork(mfWork, mfOffer);
        }
        if (flag == 0) {
            return new JsonResult<>("200", "添加失败");
        }
        return new JsonResult<>("200", "添加成功", mfWork);
    }

    /**
     * 去到生产页面
     *
     * @param workId  工单id
     * @param model   模型
     * @param request 请求
     * @return 具体页面
     */
    @RequestMapping("/print/produce/{workId}")
    public String printProduce(@PathVariable("workId") Long workId, Model model, HttpServletRequest request) {

        MfWork work = null;
        MfOffer mfOffer = null;
        if (ConstantUtil.USER_TYPE_COLOR.equals(request.getSession().getAttribute("user"))) {
            work = mfWorkService.queryDataById(workId);
            System.out.println("查询出来的work" + work);
            mfOffer = mfOfferService.queryOfferById(work.getWorkOfferId());
        } else {
            work = mfWorkHbService.queryDataById(workId);
            mfOffer = mfOfferBlackService.queryOfferById(work.getWorkOfferId());
        }
        //这里要注入我们的特殊值,先要获取当前work对应的offer
        if (mfOffer.getTypeId() == 1 || mfOffer.getTypeId() == 2) {
            work.setCoverPostsNumber(CountUtil.getPostsNumber(mfOffer.getOfferCoverP(), mfPaperService.getKaiBie(work.getProductSizeId())));
            work.setCorePostsNumber(CountUtil.getPostsNumber(mfOffer.getOfferCoreP(), mfPaperService.getKaiBie(work.getProductSizeId())));
        } else {
            work.setCorePostsNumber(CountUtil.getPostsNumber(mfOffer.getOfferCoreP(), mfPaperService.getKaiBie(work.getProductSizeId())));
        }
        if (work.getWorkInsetGrammage() != null) {
            work.setInsetPostsNumber(CountUtil.getPostsNumber(mfOffer.getOfferInsetP(), mfPaperService.getKaiBie(work.getProductSizeId())));
        }
        model.addAttribute("work", work);
        return "work/work_print_page";
    }

    /**
     * 分页查询完整工单
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
            pageUtils = mfWorkService.queryByPage(currentPage, pageSize);
        } else {
            pageUtils = mfWorkHbService.queryByPage(currentPage, pageSize);
        }
        //计算出初始值
        return pageUtils;
    }
}