package mf_offer_system.springboot_02.service.impl;

import mf_offer_system.springboot_02.entity.MfOffer;
import mf_offer_system.springboot_02.service.MfPaperService;
import mf_offer_system.springboot_02.service.MfTonpriceService;
import mf_offer_system.springboot_02.service.OfferService;
import mf_offer_system.springboot_02.util.CountUtil;
import mf_offer_system.springboot_02.util.GetYinBanNumber;
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
                mfOffer = blackAlbum(mfOffer);
                break;
            case 3:
                mfOffer = pictureSingle(mfOffer);
                break;
            case 4:
                mfOffer = blackSingle(mfOffer);
                break;
            default:
                break;
        }
        return mfOffer;
    }

    /**
     * 计算黑白单页
     *
     * @param mfOffer 报价单
     * @return 计算后的报价
     */
    private MfOffer blackSingle(MfOffer mfOffer) {
        //根据数量获取放数
        Integer number = mfOffer.getOfferNumber();
        //获取开别
        int kaiBie = mfPaperService.getKaiBie(mfOffer.getSizeId());
        System.out.println("开别是" + kaiBie);
        double v1 = mfTonpriceService.countSinglePaper(mfOffer, 2);
        System.out.println("内芯纸张单价" + v1);
        double coreP = mfOffer.getOfferCoreP();
        double corePaperNum = CountUtil.getPaperNumber(coreP, kaiBie, number,2);
        double corePaperPriceCore = corePaperNum * v1;
        System.out.println("内芯纸数量" + corePaperNum);
        //版费 p数/开别*机型=板数*根据版数量判断的价格(板数<20 10元一张，大于20-40 9块  大于40 8块)
        double moldCostNum = mfOffer.getOfferCoreP() / (kaiBie * 2.0) * 8.0;
        System.out.println("印版数量" + moldCostNum);
        double allMoldCost = CountUtil.getMold(moldCostNum) * moldCostNum;//1000以下 0.02 1000-3000 0.015 3000 0.01
        System.out.println("版费" + allMoldCost);
        //印工  p/开别*机型*成品数量*(根据数量算出单价  500以下  0.02  500-1500 0.015  >1500 0.01)
        double printerPrice = mfOffer.getOfferCoreP() / (kaiBie * 2.0) * 8.0 * mfOffer.getOfferNumber() * CountUtil.getSinglePrinter(mfOffer.getOfferNumber());
        System.out.println("内芯印工" + printerPrice);
        //设置内芯价格
        mfOffer.setOfferCorePrice((float) (corePaperPriceCore + allMoldCost + printerPrice));
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
        float totalPrice = mfOffer.getOfferMachiningPrice() + mfOffer.getOfferCorePrice() + mfOffer.getOfferDeliveryPrice();
        mfOffer.setOfferTotalPrice(totalPrice);
        return mfOffer;
    }

    /**
     * 计算彩色单页
     *
     * @param mfOffer 报价单
     * @return 计算后的报价
     */
    private MfOffer pictureSingle(MfOffer mfOffer) {
        Integer number = mfOffer.getOfferNumber();
        //获取开别
        int kaiBie = mfPaperService.getKaiBie(mfOffer.getSizeId());
        //获取数量
        double v1 = mfTonpriceService.countSinglePaper(mfOffer, 2);
        System.out.println("内芯纸张单价" + v1);
        double coreP = mfOffer.getOfferCoreP();
//        double corePaperNum = (int) ((coreP / kaiBie * number) % 4 == 0 ? (coreP / kaiBie * number) / 4 : (coreP / kaiBie * number) / 4 + 1);
        double corePaperNum = CountUtil.getPaperNumber(coreP, kaiBie, number,1);
        double corePaperPriceCore = corePaperNum * v1;
        System.out.println("内芯纸数量" + corePaperNum);
        //获取印工价格
        double corePrintPriceCore = (mfOffer.getOfferCoreP() % 4 == 0 ? mfOffer.getOfferCoreP() / 4 : mfOffer.getOfferCoreP() / 4 + 1) * GetYinBanNumber.getYinBanNumber(mfOffer.getOfferNumber());
        mfOffer.setOfferCorePrice((float) (corePaperPriceCore + corePrintPriceCore));
        System.out.println("内芯印工价格" + corePrintPriceCore + "\t内芯总价" + mfOffer.getOfferCorePrice() + "\t内芯纸价" + corePaperPriceCore);
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
        float totalPrice = mfOffer.getOfferMachiningPrice() + mfOffer.getOfferCorePrice() + mfOffer.getOfferDeliveryPrice();
        mfOffer.setOfferTotalPrice(totalPrice);
        return mfOffer;
    }


    /**
     * 计算黑白价格的方法
     *
     * @param mfOffer mf报价单
     * @return mf报价单
     */
    private MfOffer blackAlbum(MfOffer mfOffer) {
        //首先计算封面
        //获取单价
        double v = mfTonpriceService.countSinglePaper(mfOffer, 1);
        System.out.println("黑白封面单价" + v);
        //获取封面数量
        //根据数量获取放数
        Integer number = mfOffer.getOfferNumber();
        //获取开别
        int kaiBie = mfPaperService.getKaiBie(mfOffer.getSizeId());
        System.out.println("开别是" + kaiBie);
        double coverP = mfOffer.getOfferCoverP();
        double v1 = mfTonpriceService.countSinglePaper(mfOffer, 2);
        System.out.println("内芯纸张单价" + v1);
        double coreP = mfOffer.getOfferCoreP();
        //下面是单色算法
        //16开单面2分
        //2p  16开  2分 p数/开别*8*0.02 一张封面的价格*数量 0.08
        if (mfOffer.getColorIdCover() == 1) {
            double coverV = mfTonpriceService.countSinglePaper(mfOffer, 1);
            System.out.println("封面单价" + v);
            //获取封面数量
            Integer coverNumber = mfOffer.getOfferNumber();
            //获取p数/开别*数量/4*单价
            double coverPaperNum = CountUtil.getPaperNumber(coverP, kaiBie, number,1);
            System.out.println("封面指数量" + coverPaperNum);
            double coverPaperPriceCover = coverPaperNum * v;
            double coverPrinterPriceCover = (mfOffer.getOfferCoverP() % 4 == 0 ? mfOffer.getOfferCoverP() / 4 : mfOffer.getOfferCoverP() / 4 + 1) * GetYinBanNumber.getYinBanNumber(mfOffer.getOfferNumber());
            mfOffer.setOfferCoverPrive((float) (coverPaperPriceCover + coverPrinterPriceCover));
            System.out.println("封面印工" + coverPrinterPriceCover + "封面总价" + mfOffer.getOfferCoverPrive() + "\t封面纸价" + coverPaperPriceCover);
        } else if (mfOffer.getColorIdCover() == 2) {
            double coverPaperNum=(int)CountUtil.getBlackPagerNumber(coverP,kaiBie,number);
            System.out.println("封面指数量" + coverPaperNum);
            //得出封面的纸价
            double coverPaperPriceCover = coverPaperNum * v;
            System.out.println("封面纸张价格"+coverPaperNum*v);
            //版费 p数/开别*机型=板数*根据版数量判断的价格(板数<20 10元一张，大于20-40 9块  大于40 8块)
            double moldCostNum = mfOffer.getOfferCoverP() / (kaiBie * 2.0) * 8.0;
            System.out.println("封面印版数量" + moldCostNum);
            double allMoldCost = CountUtil.getMold(moldCostNum) * moldCostNum;
            System.out.println("封面版费" + allMoldCost);
            //印工  p/开别*机型*成品数量*(根据数量算出单价  500以下  0.02  500-1500 0.015  >1500 0.01)
            double printerPrice = mfOffer.getOfferCoverP() / (kaiBie * 2.0) * 8.0 * mfOffer.getOfferNumber() * CountUtil.getSinglePrinter(mfOffer.getOfferNumber());
            System.out.println("封面印工" + printerPrice);
            //设置封面价格
            mfOffer.setOfferCoverPrive((float) (coverPaperPriceCover + printerPrice + allMoldCost));
        }

        if (mfOffer.getOfferInsetGrammage() != null) {
            double insetv1 = mfTonpriceService.countSinglePaper(mfOffer, 2);
            System.out.println("插页纸张单价" + insetv1);
            double insetP = mfOffer.getOfferInsetP();
//        double corePaperNum = (int) ((coreP / kaiBie * number) % 4 == 0 ? (coreP / kaiBie * number) / 4 : (coreP / kaiBie * number) / 4 + 1);
            double insetPaperNum = CountUtil.getPaperNumber(insetP, kaiBie, number,1);
            double insetPaperPriceCore = insetPaperNum * insetv1;
            System.out.println("插页纸数量" + insetPaperNum);
            //获取印工价格
            double insetPrintPriceCore = (mfOffer.getOfferInsetP() % 4 == 0 ? mfOffer.getOfferInsetP() / 4 : mfOffer.getOfferInsetP() / 4 + 1) * GetYinBanNumber.getYinBanNumber(mfOffer.getOfferNumber());
            mfOffer.setOfferInsetPrice((float) (insetPaperPriceCore + insetPrintPriceCore));
            System.out.println("插页印工价格" + insetPrintPriceCore + "\t插页总价" + mfOffer.getOfferInsetPrice() + "\t插页纸价" + insetPaperPriceCore);
        } else if (mfOffer.getColorIdCore() == 2) {
            Integer corePaperNum = (int) (CountUtil.getBlackPagerNumber(coreP,kaiBie,number));
            double corePaperPriceCore = corePaperNum * v1;
            System.out.println("内芯纸数量" + corePaperNum);
            System.out.println("内心纸张价格"+corePaperNum*v1);
            //版费 p数/开别*机型=板数*根据版数量判断的价格(板数<20 10元一张，大于20-40 9块  大于40 8块)
            double moldCostNum = mfOffer.getOfferCoreP() / (kaiBie * 2.0) * 8.0;
            System.out.println("印版数量" + moldCostNum);
            double allMoldCost = CountUtil.getMold(moldCostNum) * moldCostNum;
            System.out.println("版费" + allMoldCost);
            //印工  p/开别*机型*成品数量*(根据数量算出单价  500以下  0.02  500-1500 0.015  >1500 0.01)
            double printerPrice = mfOffer.getOfferCoreP() / (kaiBie * 2.0) * 8.0 * mfOffer.getOfferNumber() * CountUtil.getSinglePrinter(mfOffer.getOfferNumber());
            System.out.println("内芯印工" + printerPrice);
            //设置内芯价格
            mfOffer.setOfferCorePrice((float) (corePaperPriceCore + allMoldCost + printerPrice));
        }
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

    /**
     * 计算画册报价的方法
     *
     * @param mfOffer 传进来的报价
     * @return 返回计算后的报价
     */
    private MfOffer pictureAlbum(MfOffer mfOffer) {
        //首先计算封面
        //获取单价
        double v = mfTonpriceService.countSinglePaper(mfOffer, 1);
        System.out.println("封面单价" + v);
        //获取封面数量
        //根据数量获取放数
        Integer number = mfOffer.getOfferNumber();
        //获取开别
        int kaiBie = mfPaperService.getKaiBie(mfOffer.getSizeId());
        System.out.println("开别是" + kaiBie);
        //获取p数/开别*数量/4*单价
        double coverP = mfOffer.getOfferCoverP();
        double coverPaperNum = CountUtil.getPaperNumber(coverP, kaiBie, number,1);
        System.out.println("封面指数量" + coverPaperNum);
        double coverPaperPriceCover = coverPaperNum * v;
        double coverPrinterPriceCover = (mfOffer.getOfferCoverP() % 4 == 0 ? mfOffer.getOfferCoverP() / 4 : mfOffer.getOfferCoverP() / 4 + 1) * GetYinBanNumber.getYinBanNumber(mfOffer.getOfferNumber()) ;
        mfOffer.setOfferCoverPrive((float) (coverPaperPriceCover + coverPrinterPriceCover));
        System.out.println("封面印工" + coverPrinterPriceCover + "封面总价" + mfOffer.getOfferCoverPrive() + "\t封面纸价" + coverPaperPriceCover);
        //然后计算内芯
        //首先计算内芯的单价
        //获取数量
        double v1 = mfTonpriceService.countSinglePaper(mfOffer, 2);
        System.out.println("内芯纸张单价" + v1);
        double coreP = mfOffer.getOfferCoreP();
//        double corePaperNum = (int) ((coreP / kaiBie * number) % 4 == 0 ? (coreP / kaiBie * number) / 4 : (coreP / kaiBie * number) / 4 + 1);
        double corePaperNum = CountUtil.getPaperNumber(coreP, kaiBie, number,1);
        double corePaperPriceCore = corePaperNum * v1;
        System.out.println("内芯纸数量" + corePaperNum);
        //获取印工价格
        double corePrintPriceCore = (mfOffer.getOfferCoreP() % 4 == 0 ? mfOffer.getOfferCoreP() / 4 : mfOffer.getOfferCoreP() / 4 + 1) * GetYinBanNumber.getYinBanNumber(mfOffer.getOfferNumber());
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
