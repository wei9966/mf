package mf_offer_system.springboot_02.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 复膜(MfAmoun)实体类
 *
 * @author makejava
 * @since 2020-05-09 23:48:23
 */
@Data
public class MfAmoun implements Serializable {
    private static final long serialVersionUID = 707534587285927331L;
    
    private Integer amounId;
    
    private String amounType;
    /**
    * 复膜单价
    */
    private Double amounPrice;


    public Integer getAmounId() {
        return amounId;
    }

    public void setAmounId(Integer amounId) {
        this.amounId = amounId;
    }

    public String getAmounType() {
        return amounType;
    }

    public void setAmounType(String amounType) {
        this.amounType = amounType;
    }

    public Double getAmounPrice() {
        return amounPrice;
    }

    public void setAmounPrice(Double amounPrice) {
        this.amounPrice = amounPrice;
    }

}