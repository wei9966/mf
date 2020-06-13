package mf_offer_system.springboot_02.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 报价类型表(MfType)实体类
 *
 * @author makejava
 * @since 2020-05-09 20:51:18
 */
@Data
public class MfType implements Serializable {
    private static final long serialVersionUID = 598176215711232682L;
    /**
    * 报价类型id
    */
    private Integer typeId;
    /**
    * 报价类型
    */
    private String typeName;
}