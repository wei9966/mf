package mf_offer_system.springboot_02.controller.offer;

import mf_offer_system.springboot_02.entity.*;
import mf_offer_system.springboot_02.service.*;
import mf_offer_system.springboot_02.util.GetNowDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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


    @RequestMapping("/pictureAlbum")
    public String toPictureAlbumPage(Model model) {
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
        return "offer/offer_picture_album";
    }

    @RequestMapping("/price")
    @ResponseBody
    public String offerPrice(@RequestBody MfOffer mfOffer) {
        //获取当前时间并注入
        //计算画册价格 参数时mfOffer
        //算出价格将价格注入这个对象并返回
        System.out.println(mfOffer);
        mfOffer.setOfferTime(GetNowDate.getNowDate());
        mfOfferService.insert(mfOffer);
        return "120";
    }

}
