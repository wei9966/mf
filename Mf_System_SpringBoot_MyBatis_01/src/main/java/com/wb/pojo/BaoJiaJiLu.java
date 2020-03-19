package com.wb.pojo;

/**
 * 报价记录实体类
 */
public class BaoJiaJiLu {
    private int id;
    private String date;
    private String cName;
    private String pName;
    private int count;
    private double resultMoney;
    private int flag;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getResultMoney() {
        return resultMoney;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public void setResultMoney(double resultMoney) {
        this.resultMoney = resultMoney;
    }

    @Override
    public String toString() {
        return "BaoJiaJiLu{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", cName='" + cName + '\'' +
                ", pName='" + pName + '\'' +
                ", count=" + count +
                ", resultMoney=" + resultMoney +
                ", flag=" + flag +
                '}';
    }
}
