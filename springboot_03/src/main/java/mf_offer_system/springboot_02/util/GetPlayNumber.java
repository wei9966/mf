package mf_offer_system.springboot_02.util;

/**
 * Create By WeiBin on 2020/5/13 11:09
 * 获取放数
 *
 * @author WB
 */
public class GetPlayNumber {
    /**
     * 根据彩色数量获取放数
     * 黑白放数60  彩色200
     * @return
     */
    public static Integer getPlayNumber(Integer number,Integer type) {
        if (type==1){
            return 100;
        }else if (type==2){
            //1000 以下  50   1000-3000 80  3000-10000  100  10000以上 150
            if (number<1000){
                return 50;
            }else if(number<3000){
                return 80;
            }else if(number<10000){
                return 100;
            }else if(number>10000){
                return 150;
            }
        }
        return 0;
    }

    public static Integer getPlayNumber(Integer p,Integer kaibie,Integer type) {
            //获取板数
        int bp = 4*p % (kaibie * 2)==0?4*p/(kaibie*2): (4*p/(kaibie*2))+1;
        System.out.println("彩色为板数"+bp+"张"+"放数为"+bp*100);
        return bp*100;
    }


}
