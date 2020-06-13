package mf_offer_system.springboot_02.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 装订方式(MfBingding)实体类
 *
 * @author makejava
 * @since 2020-05-09 23:48:31
 */
@Data
public class MfBingding implements Serializable {
    private static final long serialVersionUID = -13245004301789591L;
    
    private Integer bindingId;
    
    private String bindingType;
    
    private Double bindingPrice;


    public Integer getBindingId() {
        return bindingId;
    }

    public void setBindingId(Integer bindingId) {
        this.bindingId = bindingId;
    }

    public String getBindingType() {
        return bindingType;
    }

    public void setBindingType(String bindingType) {
        this.bindingType = bindingType;
    }

    public Double getBindingPrice() {
        return bindingPrice;
    }

    public void setBindingPrice(Double bindingPrice) {
        this.bindingPrice = bindingPrice;
    }

}