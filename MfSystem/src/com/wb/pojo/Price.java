package com.wb.pojo;

/**
 * 纸张单价计算类
 */
public class Price {
    /**
     * 吨价
     */
    private double dPrice;
    /**
     * 尺寸
     */
    private String size;
    /**
     * 克度
     */
    private int kd;

    public double getdPrice() {
        return dPrice;
    }

    public void setdPrice(double dPrice) {
        this.dPrice = dPrice;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getKd() {
        return kd;
    }

    public void setKd(int kd) {
        this.kd = kd;
    }

    public double zh(){
        if (size.contains("大度")){
            return 1884;
        }else if(size.contains("正度")) {
            return 2327;
        }else {
            return 0;
        }
    }
}
