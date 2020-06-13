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
}