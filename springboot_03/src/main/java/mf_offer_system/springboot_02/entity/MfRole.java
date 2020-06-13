package mf_offer_system.springboot_02.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 角色表(MfRole)实体类
 *
 * @author makejava
 * @since 2020-05-10 22:56:48
 */
@Data
public class MfRole implements Serializable {
    private static final long serialVersionUID = -89794330707021411L;
    /**
    * 角色id
    */
    private Integer roleId;
    /**
    * 角色类型
    */
    private String roleType;
    /**
    * 权限id
    */
    private Integer permissiorId;

}