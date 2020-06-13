package mf_offer_system.springboot_02.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Create By WeiBin on 2020/5/10 8:42
 * @author WB
 */
public class GetNowDate {

        public final static String DATE_PATTERN_01="yyyy-MM-dd HH:mm:ss";
        private static SimpleDateFormat simpleDateFormat;
        private GetNowDate(){

        }

        public static Date getNowDate(){
                simpleDateFormat=new SimpleDateFormat(DATE_PATTERN_01);
                return new Date();
        }

}
