package com.wb.util;

import com.wb.pojo.Price;

/**
 * 计算报价的工具类
 */
public class CountUtil {
    /**
     * 纸张单价
     */
    public static double getPageSingle(Price price){
      double a=  price.getdPrice()/price.zh()*price.getKd()/500;
        return a;
    }

    /**
     * 获取放数
     * @param
     * @return
     */
    public static int getZount(int c){
      if (c<5000){
            return 200;
      }else {
          return 300;
      }
    }

    /**
     * 获取开别
     * @param b
     * @return
     */
    public static int getKaiBie(String b){
        if (b.contains("32开")){
            return 16;
        }else if(b.contains("16开")){
            return 8;
        }else if(b.contains("8开")){
            return 4;
        }else if(b.contains("4开")){
            return 2;
        }else {
            return 0;
        }
    }

    public static int getYinBanCount(int p){
        int i=p%4==0?p/4:p/4+1;
        return i;
    }
}
