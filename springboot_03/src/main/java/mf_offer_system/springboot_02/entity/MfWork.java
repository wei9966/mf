package mf_offer_system.springboot_02.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 工单表(MfWork)实体类
 *
 * @author makejava
 * @since 2020-05-13 22:28:48
 */
@Data
public class MfWork implements Serializable {
    private static final long serialVersionUID = -35862865345812306L;
    /**
    * 工单编号
    */
    private Long workId;
    /**
    * 工单打印时间
    */
    private Date workTime;
    /**
    * 客户名
    */
    private String workCustomerName;
    /**
    * 产品名称
    */
    private String workProductName;
    /**
    * 产品数量
    */
    private Integer workNumber;
    /**
    * 交货时间
    */
    private Date workDeliveryTime;
    /**
    * 报价时间
    */
    private Date workOfferTime;
    /**
    * 机台
    */
    private Integer machineId;
    /**
    * 产品尺寸
    */
    private Integer productSizeId;
    /**
    * 拼板尺寸
    */
    private Integer paneSizeId;
    /**
    * 封面克数
    */
    private Integer workCoverGrammage;
    /**
    * 内芯克数
    */
    private Integer workCoreGrammage;
    /**
    * 插页克数
    */
    private Integer workInsetGrammage;
    /**
    * 内芯纸型
    */
    private Integer corePaperId;
    /**
    * 封面纸型
    */
    private Integer coverPaperId;
    /**
    * 插页纸型
    */
    private Integer insetPaperId;
    /**
    * 封面开别
    */
    private Integer workCoverLeave;
    /**
    * 内芯开别
    */
    private Integer workCoreLeave;
    /**
    * 插页开别
    */
    private Integer workInsetLeave;
    /**
    * 封面放数
    */
    private Integer workCoverPlayNumber;
    /**
    * 内芯放数
    */
    private Integer workCorePlayNumber;
    /**
    * 内芯放数
    */
    private Integer workInsetPlayNumber;
    /**
    * 封面合全开数
    */
    private Integer workCoverAlloysNumber;
    /**
    * 内芯合全开数
    */
    private Integer workCoreAlloysNumber;
    /**
    * 插页合全开数
    */
    private Integer workInsetAlloysNumber;
    /**
    * 封面墨色
    */
    private Integer coverColorId;
    /**
    * 插页墨色
    */
    private Integer insetColorId;
    /**
    * 内芯墨色
    */
    private Integer coreColorId;
    /**
    * 封面印版数量
    */
    private Integer workCoverPlateNumber;
    /**
    * 内芯印版数量
    */
    private Integer workCorePlateNumber;
    /**
    * 插页印版数量
    */
    private Integer workInsetPlateNumber;
    /**
    * 封面价格
    */
    private Float workCoverPrice;
    /**
    * 内芯价格
    */
    private Float workCorePrice;
    /**
    * 后加工价格
    */
    private Float workPostProcessPrice;
    /**
    * 总价
    */
    private Float workTotalPrice;
    /**
    * 后加工
    */
    private String workPostProcessing;
    /**
    * 备注
    */
    private String workRemarks;



    /**
     * 报价id
     */
    private Long workOfferId;
    /**
     * 机台类型
     */
    private String machineType;
    /**
     * 产品尺寸类型
     */
    private String productSizeType;
    /**
     * 产品尺寸类型
     */
    private String paneSizeType;
    /**
     * 内芯纸型类型
     */
    private String corePaperType;
    /**
     * 封面纸型类型
     */
    private String coverPaperType;
    /**
     * 插页纸型类型
     */
    private String insetPaperType;
    /**
     * 封面墨色
     */
    private String coverColorType;
    /**
     * 内芯墨色
     */
    private String coreColorType;
    /**
     *插页墨色
     */
    private String insetColorType;
    /**
     * 封面贴数
     */
    private double coverPostsNumber;
    /**
     * 内芯贴数
     */
    private double corePostsNumber;
    /**
     * 插页贴数
     */
    private double insetPostsNumber;

}