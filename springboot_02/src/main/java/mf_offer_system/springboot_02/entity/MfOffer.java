package mf_offer_system.springboot_02.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 明发报价表(MfOffer)实体类
 *
 * @author makejava
 * @since 2020-05-09 23:48:09
 */
@Data
public class MfOffer implements Serializable {
    private static final long serialVersionUID = 872625475528827009L;
    /**
    * 报价id
    */
    private Long offerId;
    /**
    * 报价类型
    */
    private Integer typeId;
    /**
    * 生产标志
    */
    private Integer offerProduceId;
    /**
    * 报价日期
    */
    private Date offerTime;
    /**
    * 客户名称
    */
    private String offerCustomerName;
    /**
    * 产品名称
    */
    private String offerProductName;
    /**
    * 尺寸
    */
    private Integer sizeId;
    /**
    * 产品数量
    */
    private Integer offerNumber;
    /**
    * 封面克数
    */
    private Integer offerCoverGrammage;
    /**
    * 封面纸型
    */
    private Integer paperIdCover;
    /**
    * 封面P数
    */
    private Integer offerCoverP;
    /**
    * 封面墨色
    */
    private Integer colorIdCover;
    /**
    * 封面价格
    */
    private Float offerCoverPrive;
    /**
    * 内芯克数
    */
    private Integer offerCoreGrammage;
    /**
    * 内芯纸型
    */
    private Integer paperIdCore;
    /**
    * 内芯P数
    */
    private Integer offerCoreP;
    /**
    * 内芯墨色
    */
    private Integer colorIdCore;
    /**
    * 内芯价格
    */
    private Float offerCorePrice;
    /**
    * 插页克数
    */
    private Integer offerInsetGrammage;
    /**
    * 插页纸型
    */
    private Integer paperIdInset;
    /**
    * 插页p数
    */
    private Integer offerInsetP;
    /**
    * 插页墨色
    */
    private Integer colorIdInset;
    /**
    * 插页金额
    */
    private Float offerInsetPrice;
    /**
    * 复膜金额
    */
    private Float offerAmounPrice;
    
    private Integer amounId;
    /**
    * 装订金额
    */
    private Float offerBindingPrice;
    
    private Integer bindingId;
    /**
    * 配送金额
    */
    private Float offerDeliveryPrice;
    /**
    * 工艺1金额
    */
    private Float offerProcess1Price;
    /**
    * 工艺2金额
    */
    private Float offerProcess2Price;
    /**
    * 工艺3金额
    */
    private Float offerProcess3Price;
    /**
    * 工艺4金额
    */
    private Float offerProcess4Price;
    /**
    * 工艺5金额
    */
    private Float offerProcess5Price;
    /**
    * 工艺1名称
    */
    private String offerProcess1Name;
    /**
    * 工艺2名称
    */
    private String offerProcess2Name;
    /**
    * 工艺3名称
    */
    private String offerProcess3Name;
    /**
    * 工艺4名称
    */
    private String offerProcess4Name;
    /**
    * 工艺5名称
    */
    private String offerProcess5Name;
    /**
    * 加工金额
    */
    private Float offerMachiningPrice;
    /**
    * 总金额
    */
    private Float offerTotalPrice;

    private String sizeType;
    private String paperCoverType;
    private String paperCoreType;
    private String paperInsetType;
    private String coverColorType;
    private String coreColorType;
    private String insetColorType;
    private String type;
    private String bindingType;
    private String amounType;

}