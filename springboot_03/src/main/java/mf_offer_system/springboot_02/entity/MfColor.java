package mf_offer_system.springboot_02.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 墨色表(MfColor)实体类
 *
 * @author makejava
 * @since 2020-05-09 20:48:22
 */
@Data
public class MfColor implements Serializable {
    private static final long serialVersionUID = 727830497721090403L;
    /**
    * 墨色id
    */
    private Integer colorId;
    /**
    * 墨色类型
    */
    private String colorType;


    public Integer getColorId() {
        return colorId;
    }

    public void setColorId(Integer colorId) {
        this.colorId = colorId;
    }

    public String getColorType() {
        return colorType;
    }

    public void setColorType(String colorType) {
        this.colorType = colorType;
    }

}