package mf_offer_system.springboot_02.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 纸张类型(MfPaper)实体类
 *
 * @author makejava
 * @since 2020-05-09 20:50:39
 */
@Data
public class MfPaper implements Serializable {
    private static final long serialVersionUID = -54366959529972776L;
    
    private Integer paperId;
    /**
    * 纸张类型
    */
    private String paperType;


    public Integer getPaperId() {
        return paperId;
    }

    public void setPaperId(Integer paperId) {
        this.paperId = paperId;
    }

    public String getPaperType() {
        return paperType;
    }

    public void setPaperType(String paperType) {
        this.paperType = paperType;
    }

}