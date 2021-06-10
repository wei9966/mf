package mf_offer_system.springboot_02.util;

/**
 * Create By WeiBin on 2020/6/19 15:45
 * @author WB
 */
public class GetYinBanNumber {

    public static int getYinBanNumber(Integer offerNumber) {
        if (offerNumber>0 && offerNumber<200){
            return 140;
        }else if (offerNumber<500){
            return 160;
        }else if (offerNumber<1000){
            return 180;
        }else if (offerNumber<2000){
            return 200;
        }else if (offerNumber<3000){
            return 220;
        }else if (offerNumber<4000){
            return 240;
        }
        return 0;
    }
}
