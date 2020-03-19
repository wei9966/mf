package com.wb.pojo.work;

public class DuiZhang {
    private String cName;
    private double money;

    @Override
    public String toString() {
        return "DuiZhang{" +
                ", cName='" + cName + '\'' +
                ", money=" + money +
                '}';
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
