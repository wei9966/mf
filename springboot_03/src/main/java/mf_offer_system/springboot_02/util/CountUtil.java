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
                binding = (mfOffer.getOfferCoreP() / 8.0 * 0.03 + 0.35) * mfOffer.getOfferNumber();
            } else {
                binding = (mfOffer.getOfferCoreP() / 8.0 * 0.03 + 0.25) * mfOffer.getOfferNumber();
            }
        } else if (mfOffer.getBindingId() == 2) {
            //不到100元按照100算
            binding = (mfOffer.getOfferCoreP() / 8.0 * 0.03 + 0.05) * mfOffer.getOfferNumber();
            if (binding < 100) {
                binding = 100;
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

    /**
     * @param p      p数
     * @param kaiBie 开别
     * @param number 填写的份数
     * @return 所用的纸张数量
     */
    public static Integer getPaperNumber(double p, Integer kaiBie, Integer number, Integer type) {
        //2个p放数400 4个p200
        Integer result = null;
        if (type == 1) {
            result = (int) (((getPostsNumber(p, kaiBie) * number) + GetPlayNumber.getPlayNumber((int)p, kaiBie,type)) % 4 == 0 ? (((getPostsNumber(p, kaiBie) * number) + GetPlayNumber.getPlayNumber((int)p, kaiBie,type))  / 4) : (((getPostsNumber(p, kaiBie) * number) + GetPlayNumber.getPlayNumber((int)p, kaiBie,type))/4  + 1));
        } else if (type == 2) {
            result = (int) (((getPostsNumber(p, kaiBie) * number) + GetPlayNumber.getPlayNumber(number, type)) % 4 == 0 ? (((getPostsNumber(p, kaiBie)) * number) + GetPlayNumber.getPlayNumber(number, type)) / 4 : ((((getPostsNumber(p, kaiBie) * number) + GetPlayNumber.getPlayNumber(number, type)) / 4) + 1));
        }

        return result;
    }

    /**
     * 获取贴数
     *
     * @param p      p数
     * @param kaiBie 开别
     * @return 贴数
     */
    public static double getPostsNumber(double p, Integer kaiBie) {
        double result = p / kaiBie;
        return result;
    }

    /**
     * 得出印版数量
     *
     * @param p
     * @param kaiBie
     * @param type
     * @return
     */
    public static Integer getLeaveNum(double p, Integer kaiBie, String type) {
        Integer result = (int) (p / kaiBie * getMechineInteger(type));
        return result;
    }

    public static Integer getMechineInteger(String type) {
        if (type.equals("四开机")) {
            return 4;
        } else if (type.equals("八开机")) {
            return 8;
        } else if (type.equals("二开机")) {
            return 2;
        }
        return 0;
    }

    /**
     * 根据印版数量获取印版单价
     * 板数<20 10元一张，大于20-40 9块  大于40 8块
     *
     * @param singleMoldCost 印版数量
     * @return
     */
    public static double getMold(double singleMoldCost) {
        if (singleMoldCost < 20 && singleMoldCost > 0) {
            return 10;
        } else if (singleMoldCost < 40) {
            return 9;
        } else {
            return 8;
        }
    }

    /**
     * 根据成品数量获取单价
     * 印工  p/开别*机型*成品数量*(根据数量算出单价  500以下  0.02  500-1500 0.015  >1500 0.01)
     *
     * @param offerNumber 成品数量
     * @return 返回单价
     */
    public static double getSinglePrinter(Integer offerNumber) {
        if (offerNumber <= 1000 && offerNumber > 0) {
            return 0.02;
        } else if (offerNumber <= 3000) {
            return 0.015;
        } else {
            return 0.01;
        }
    }

    public static double getBlackPagerNumber(double coverP, int kaiBie, Integer number) {
        System.out.println(coverP+"\t"+kaiBie+"\t"+number);
        double v = coverP / (kaiBie * 2);
        double v1 = v * 8;
        double v2 = v1 / 2;
        Integer playNumber = GetPlayNumber.getPlayNumber(number, 2);
        double v3 = v2 * (playNumber + number);
        System.out.println("计算步骤"+v+"\t"+v1+"\t"+v2+"\t"+playNumber+"\t"+v3);
        double v4 = v3 % 8 == 0 ? v3 / 8 : (v3 / 8) + 1;
        return v4;
    }
}
