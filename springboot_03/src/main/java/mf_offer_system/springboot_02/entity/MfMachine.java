package mf_offer_system.springboot_02.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 机台(MfMachine)实体类
 *
 * @author makejava
 * @since 2020-05-13 11:57:01
 */
@Data
public class MfMachine implements Serializable {
    private static final long serialVersionUID = 969041055396214842L;
    /**
    * 机台id
    */
    private Integer machineId;
    /**
    * 机台类型
    */
    private String machineType;

}