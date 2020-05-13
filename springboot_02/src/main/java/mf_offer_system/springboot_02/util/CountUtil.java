package mf_offer_system.springboot_02.util;

import mf_offer_system.springboot_02.entity.MfOffer;

/**
 * Create By WeiBin on 2020/5/10 21:27
 *
 * @author WB
 */
public class CountUtil {

    /**
     * 算出复膜价格
     *
     * @param mfOffer
     * @return
     */
    public static double getAmoun(MfOffer mfOffer) {
        if (mfOffer.getAmounId() == null) {
            return 0;
        }
        double fumo = 0;
        //根据复膜id来判断我们的复膜价格
        Integer amounId = mfOffer.getAmounId();
        //光膜
        if (amounId == 1) {
            fumo = mfOffer.getOfferNumber() * 0.11;
            if (fumo < 50) {
                fumo = 50;
            }
        } else if (amounId == 2) {
            fumo = mfOffer.getOfferNumber() * 0.12;
            if (fumo < 50) {
                fumo = 50;
            }
        }
        System.out.println("复膜价格为" + fumo);
        return fumo;
    }

    public static double getBinding(MfOffer mfOffer) {
        double binding = 0;
        if (mfOffer.getBindingId() == null) {
            return 0;
        }
        if (mfOffer.getBindingId() == 1) {
            if (mfOffer.getOfferCoreP() < 200) {
                binding = (mfOffer.getOfferCoreP() / 8 * 0.03 + 0.35) * mfOffer.getOfferNumber();
            } else {
                binding = (mfOffer.getOfferCoreP() / 8 * 0.03 + 0.25) * mfOffer.getOfferNumber();
            }
        } else if (mfOffer.getBindingId() == 2) {
            //不到100元按照100算
            binding = (mfOffer.getOfferCoreP() / 8 * 0.03 + 0.05) * mfOffer.getOfferNumber();
            if (binding<100){
                binding=100;
            }
        }
        System.out.println("装订价格为" + binding);
        return binding;
    }

    public static double getProcessorPrice(MfOffer mfOffer) {
        double processorPrice = 0;
        if (mfOffer.getOfferProcess1Name() != null) {
            processorPrice += mfOffer.getOfferProcess1Price();
        }

        if (mfOffer.getOfferProcess2Name() != null) {
            processorPrice += mfOffer.getOfferProcess2Price();
        }

        if (mfOffer.getOfferProcess3Name() != null) {
            processorPrice += mfOffer.getOfferProcess3Price();
        }

        if (mfOffer.getOfferProcess4Name() != null) {
            processorPrice += mfOffer.getOfferProcess4Price();
        }

        if (mfOffer.getOfferProcess5Name() != null) {
            processorPrice += mfOffer.getOfferProcess5Price();
        }
        System.out.println("特殊价格" + processorPrice);
        return processorPrice;
    }

}
