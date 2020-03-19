package com.wb.pojo;

/**
 * 计算出来的金额
 */
public class ResultMoney {
    private double fmResult;
    private double nxResult;
    private double hjgResult;
    private double psResult;
    private double cyResult;
    private double resultMoney;
    public double getFmResult() {
        return fmResult;
    }

    public void setFmResult(double fmResult) {
        this.fmResult = fmResult;
    }

    public double getNxResult() {
        return nxResult;
    }

    public void setNxResult(double nxResult) {
        this.nxResult = nxResult;
    }

    public double getHjgResult() {
        return hjgResult;
    }

    public void setHjgResult(double hjgResult) {
        this.hjgResult = hjgResult;
    }

    public double getPsResult() {
        return psResult;
    }

    public void setPsResult(double psResult) {
        this.psResult = psResult;
    }

    public double getResultMoney() {
        return resultMoney;
    }

    public void setResultMoney(double resultMoney) {
        this.resultMoney = resultMoney;
    }

    public double getCyResult() {
        return cyResult;
    }

    public void setCyResult(double cyResult) {
        this.cyResult = cyResult;
    }

    public double ResultMoney(){
        return fmResult+nxResult+cyResult+hjgResult+psResult;
    }
}
