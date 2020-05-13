package mf_offer_system.springboot_02;

import mf_offer_system.springboot_02.entity.MfOffer;
import mf_offer_system.springboot_02.service.MfOfferService;
import mf_offer_system.springboot_02.service.MfTonpriceService;
import mf_offer_system.springboot_02.service.OfferService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot02ApplicationTests {

    @Autowired
    MfTonpriceService mfTonpriceService;

    @Autowired
    private OfferService offerService;
    @Autowired
    private MfOfferService mfOfferService;

    /**
     * 测试纸张单价
     */
    @Test
    void contextLoads() {
        MfOffer mfOffer = new MfOffer();
        mfOffer.setPaperIdCover(1);
        mfOffer.setSizeId(7);
        mfOffer.setOfferCoverGrammage(80);
        double v = mfTonpriceService.countSinglePaper(mfOffer, 1);
        System.out.println("计算出来的单价是" + v);
    }

    @Test
    void testCoverCore() {
        MfOffer mfOffer = new MfOffer();
        mfOffer.setTypeId(1);
        mfOffer.setOfferNumber(500);
        mfOffer.setPaperIdCover(2);
        mfOffer.setSizeId(3);
        mfOffer.setOfferCoverGrammage(250);
        mfOffer.setOfferCoverP(4);
        mfOffer.setOfferCoreP(56);
        mfOffer.setOfferCoreGrammage(157);
        mfOffer.setPaperIdCore(2);
        offerService.countPrice(mfOffer);
        System.out.println(mfOffer);
        System.out.println("内芯价格" + mfOffer.getOfferCorePrice() + "\t封面价格" + mfOffer.getOfferCoverPrive());
    }

    @Test
    void testMfOffer() {
        MfOffer mfOffer = mfOfferService.queryOfferById((long) 7);
        System.out.println(mfOffer);
    }

}
