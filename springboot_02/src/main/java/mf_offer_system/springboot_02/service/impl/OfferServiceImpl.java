package mf_offer_system.springboot_02.service.impl;

import mf_offer_system.springboot_02.entity.MfOffer;
import mf_offer_system.springboot_02.service.MfPaperService;
import mf_offer_system.springboot_02.service.MfTonpriceService;
import mf_offer_system.springboot_02.service.OfferService;
import mf_offer_system.springboot_02.util.CountUtil;
import mf_offer_system.springboot_02.util.GetPlayNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Create By WeiBin on 2020/5/10 12:10
 */
@Service
public class OfferServiceImpl implements OfferService {

    @Autowired
    private MfTonpriceService mfTonpriceService;

    @Autowired
    private MfPaperService mfPaperService;

    @Override
    public MfOffer countPrice(MfOffer mfOffer) {
        switch (mfOffer.getTypeId()) {
            case 1:
                //画册就调用画册报价的方法
                mfOffer = pictureAlbum(mfOffer);
                break;
            case 2:
                break;
            case 3:
                break;
            default:
                break;
        }
        return null;
    }

    private MfOffer pictureAlbum(MfOffer mfOffer) {
        //首先计算封面
        //获取单价
        double v = mfTonpriceService.countSinglePaper(mfOffer, 1);
        System.out.println("封面单价" + v);
        //获取封面数量
        //根据数量获取放数
        double number = mfOffer.getOfferNumber() + GetPlayNumber.getPlayNumber(mfOffer.getOfferNumber());
        //获取开别
        int kaiBie = mfPaperService.getKaiBie(mfOffer.getSizeId());
        System.out.println("开别是" + kaiBie);
        //获取p数/开别*数量/4*单价
        double coverP = mfOffer.getOfferCoverP();
        int coverPaperNum = (int) ((coverP / kaiBie * number) % 4 == 0 ? (coverP / kaiBie * number) / 4 : (coverP / kaiBie * number) / 4 + 1);
        System.out.println("封面指数量" + coverPaperNum);
        double coverPaperPriceCover = coverPaperNum * v;
        double coverPrinterPriceCover = (mfOffer.getOfferCoverP() % 4 == 0 ? mfOffer.getOfferCoverP() / 4 : mfOffer.getOfferCoverP() / 4 + 1) * 160;
        mfOffer.setOfferCoverPrive((float) (coverPaperPriceCover + coverPrinterPriceCover));
        System.out.println("封面印工" + coverPrinterPriceCover + "封面总价" + mfOffer.getOfferCoverPrive() + "\t封面纸价" + coverPaperPriceCover);
        //然后计算内芯
        //首先计算内芯的单价
        //获取数量
        double v1 = mfTonpriceService.countSinglePaper(mfOffer, 2);
        System.out.println("内芯纸张单价" + v1);
        double coreP = mfOffer.getOfferCoreP();
        int corePaperNum = (int) ((coreP / kaiBie * number) % 4 == 0 ? (coreP / kaiBie * number) / 4 : (coreP / kaiBie * number) / 4 + 1);
        double corePaperPriceCore = corePaperNum * v1;
        System.out.println("内芯纸数量" + corePaperNum);
        //获取印工价格
        double corePrintPriceCore = (mfOffer.getOfferCoreP() % 4 == 0 ? mfOffer.getOfferCoreP() / 4 : mfOffer.getOfferCoreP() / 4 + 1) * 160;
        mfOffer.setOfferCorePrice((float) (corePaperPriceCore + corePrintPriceCore));
        System.out.println("内芯印工价格" + corePrintPriceCore + "\t内芯总价" + mfOffer.getOfferCorePrice() + "\t内芯纸价" + corePaperPriceCore);
        //然后判断是否有插页计算插页
        if (mfOffer.getOfferInsetGrammage() == null) {
            mfOffer.setOfferInsetPrice(0F);
        }
        //然后计算后加工的钱(复膜和装订)
        //计算复膜
        double amoun = CountUtil.getAmoun(mfOffer);
        //注入复膜金额
        mfOffer.setOfferAmounPrice((float) amoun);
        //计算装订
        double binding = CountUtil.getBinding(mfOffer);
        //注入装订金额
        mfOffer.setOfferBindingPrice((float) binding);
        //计算看是否有其他特殊的加工
        double processorPrice = CountUtil.getProcessorPrice(mfOffer);
        //然后算出后加工的钱
        mfOffer.setOfferMachiningPrice((float) (amoun + binding + processorPrice));
        //最后注入值返回
        System.out.println("后加工的价格" + mfOffer.getOfferMachiningPrice());
        //注入总价
        float totalPrice = mfOffer.getOfferMachiningPrice() + mfOffer.getOfferCorePrice() + mfOffer.getOfferInsetPrice() + mfOffer.getOfferDeliveryPrice() + mfOffer.getOfferCoverPrive();
        mfOffer.setOfferTotalPrice(totalPrice);
        return mfOffer;
    }
}
