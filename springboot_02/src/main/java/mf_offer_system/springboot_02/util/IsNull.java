package mf_offer_system.springboot_02.util;

/**
 * Create By WeiBin on 2020/5/10 12:06
 */
public class IsNull{
    /**
     * 判断对象是否为空
     * @return
     */
    public static boolean isNull(Object obj) {
        if (obj!=null){
            return true;
        }else {
            return false;
        }
    }
}
