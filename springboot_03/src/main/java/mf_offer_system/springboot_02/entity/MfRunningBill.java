package mf_offer_system.springboot_02.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 明发流水表(MfRunningBill)实体类
 *
 * @author makejava
 * @since 2020-06-07 16:39:47
 */
public class MfRunningBill implements Serializable {
    private static final long serialVersionUID = 295144794237199740L;
    /**
    * 流水id
    */
    private Integer billId;
    /**
    * 记录时间
    */
    private Date billTime;
    /**
    * 客户名称
    */
    private String billName;
    /**
    * 流水摘要
    */
    private String billAbstract;
    /**
    * 流水金额
    */
    private Object billMoney;
    /**
    * 收支类型
    */
    private String billType;
    /**
    * 收支方式
    */
    private String billMethod;
    /**
    * 流水备注
    */
    private String billRemarks;


    public Integer getBillId() {
        return billId;
    }

    public void setBillId(Integer billId) {
        this.billId = billId;
    }

    public Date getBillTime() {
        return billTime;
    }

    public void setBillTime(Date billTime) {
        this.billTime = billTime;
    }

    public String getBillName() {
        return billName;
    }

    public void setBillName(String billName) {
        this.billName = billName;
    }

    public String getBillAbstract() {
        return billAbstract;
    }

    public void setBillAbstract(String billAbstract) {
        this.billAbstract = billAbstract;
    }

    public Object getBillMoney() {
        return billMoney;
    }

    public void setBillMoney(Object billMoney) {
        this.billMoney = billMoney;
    }

    public String getBillType() {
        return billType;
    }

    public void setBillType(String billType) {
        this.billType = billType;
    }

    public String getBillMethod() {
        return billMethod;
    }

    public void setBillMethod(String billMethod) {
        this.billMethod = billMethod;
    }

    public String getBillRemarks() {
        return billRemarks;
    }

    public void setBillRemarks(String billRemarks) {
        this.billRemarks = billRemarks;
    }

}