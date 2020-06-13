package mf_offer_system.springboot_02.entity;

import java.io.Serializable;

/**
 * 拼版尺寸(MfCollage)实体类
 *
 * @author makejava
 * @since 2020-05-15 10:58:29
 */
public class MfCollage implements Serializable {
    private static final long serialVersionUID = 619315023754524910L;
    /**
    * 拼版id
    */
    private Integer collageId;
    /**
    * 拼版类型
    */
    private String collageType;


    public Integer getCollageId() {
        return collageId;
    }

    public void setCollageId(Integer collageId) {
        this.collageId = collageId;
    }

    public String getCollageType() {
        return collageType;
    }

    public void setCollageType(String collageType) {
        this.collageType = collageType;
    }

}