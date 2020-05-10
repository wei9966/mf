package mf_offer_system.springboot_02.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 吨价表(MfTonprice)实体类
 *
 * @author makejava
 * @since 2020-05-09 20:51:08
 */
@Data
public class MfTonprice implements Serializable {
    private static final long serialVersionUID = -63706203767673637L;
    /**
    * 吨价id
    */
    private Integer tpId;
    /**
    * 吨价类型
    */
    private String tpType;
    /**
    * 吨价价格
    */
    private Float tpPrice;


    public Integer getTpId() {
        return tpId;
    }

    public void setTpId(Integer tpId) {
        this.tpId = tpId;
    }

    public String getTpType() {
        return tpType;
    }

    public void setTpType(String tpType) {
        this.tpType = tpType;
    }

    public Float getTpPrice() {
        return tpPrice;
    }

    public void setTpPrice(Float tpPrice) {
        this.tpPrice = tpPrice;
    }

}