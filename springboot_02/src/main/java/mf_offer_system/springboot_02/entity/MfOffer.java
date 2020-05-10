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


    public Long getOfferId() {
        return offerId;
    }

    public void setOfferId(Long offerId) {
        this.offerId = offerId;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getOfferProduceId() {
        return offerProduceId;
    }

    public void setOfferProduceId(Integer offerProduceId) {
        this.offerProduceId = offerProduceId;
    }

    public Date getOfferTime() {
        return offerTime;
    }

    public void setOfferTime(Date offerTime) {
        this.offerTime = offerTime;
    }

    public String getOfferCustomerName() {
        return offerCustomerName;
    }

    public void setOfferCustomerName(String offerCustomerName) {
        this.offerCustomerName = offerCustomerName;
    }

    public String getOfferProductName() {
        return offerProductName;
    }

    public void setOfferProductName(String offerProductName) {
        this.offerProductName = offerProductName;
    }

    public Integer getSizeId() {
        return sizeId;
    }

    public void setSizeId(Integer sizeId) {
        this.sizeId = sizeId;
    }

    public Integer getOfferNumber() {
        return offerNumber;
    }

    public void setOfferNumber(Integer offerNumber) {
        this.offerNumber = offerNumber;
    }

    public Integer getOfferCoverGrammage() {
        return offerCoverGrammage;
    }

    public void setOfferCoverGrammage(Integer offerCoverGrammage) {
        this.offerCoverGrammage = offerCoverGrammage;
    }

    public Integer getPaperIdCover() {
        return paperIdCover;
    }

    public void setPaperIdCover(Integer paperIdCover) {
        this.paperIdCover = paperIdCover;
    }

    public Integer getOfferCoverP() {
        return offerCoverP;
    }

    public void setOfferCoverP(Integer offerCoverP) {
        this.offerCoverP = offerCoverP;
    }

    public Integer getColorIdCover() {
        return colorIdCover;
    }

    public void setColorIdCover(Integer colorIdCover) {
        this.colorIdCover = colorIdCover;
    }

    public Float getOfferCoverPrive() {
        return offerCoverPrive;
    }

    public void setOfferCoverPrive(Float offerCoverPrive) {
        this.offerCoverPrive = offerCoverPrive;
    }

    public Integer getOfferCoreGrammage() {
        return offerCoreGrammage;
    }

    public void setOfferCoreGrammage(Integer offerCoreGrammage) {
        this.offerCoreGrammage = offerCoreGrammage;
    }

    public Integer getPaperIdCore() {
        return paperIdCore;
    }

    public void setPaperIdCore(Integer paperIdCore) {
        this.paperIdCore = paperIdCore;
    }

    public Integer getOfferCoreP() {
        return offerCoreP;
    }

    public void setOfferCoreP(Integer offerCoreP) {
        this.offerCoreP = offerCoreP;
    }

    public Integer getColorIdCore() {
        return colorIdCore;
    }

    public void setColorIdCore(Integer colorIdCore) {
        this.colorIdCore = colorIdCore;
    }

    public Float getOfferCorePrice() {
        return offerCorePrice;
    }

    public void setOfferCorePrice(Float offerCorePrice) {
        this.offerCorePrice = offerCorePrice;
    }

    public Integer getOfferInsetGrammage() {
        return offerInsetGrammage;
    }

    public void setOfferInsetGrammage(Integer offerInsetGrammage) {
        this.offerInsetGrammage = offerInsetGrammage;
    }

    public Integer getPaperIdInset() {
        return paperIdInset;
    }

    public void setPaperIdInset(Integer paperIdInset) {
        this.paperIdInset = paperIdInset;
    }

    public Integer getOfferInsetP() {
        return offerInsetP;
    }

    public void setOfferInsetP(Integer offerInsetP) {
        this.offerInsetP = offerInsetP;
    }

    public Integer getColorIdInset() {
        return colorIdInset;
    }

    public void setColorIdInset(Integer colorIdInset) {
        this.colorIdInset = colorIdInset;
    }

    public Float getOfferInsetPrice() {
        return offerInsetPrice;
    }

    public void setOfferInsetPrice(Float offerInsetPrice) {
        this.offerInsetPrice = offerInsetPrice;
    }

    public Float getOfferAmounPrice() {
        return offerAmounPrice;
    }

    public void setOfferAmounPrice(Float offerAmounPrice) {
        this.offerAmounPrice = offerAmounPrice;
    }

    public Integer getAmounId() {
        return amounId;
    }

    public void setAmounId(Integer amounId) {
        this.amounId = amounId;
    }

    public Float getOfferBindingPrice() {
        return offerBindingPrice;
    }

    public void setOfferBindingPrice(Float offerBindingPrice) {
        this.offerBindingPrice = offerBindingPrice;
    }

    public Integer getBindingId() {
        return bindingId;
    }

    public void setBindingId(Integer bindingId) {
        this.bindingId = bindingId;
    }

    public Float getOfferDeliveryPrice() {
        return offerDeliveryPrice;
    }

    public void setOfferDeliveryPrice(Float offerDeliveryPrice) {
        this.offerDeliveryPrice = offerDeliveryPrice;
    }

    public Float getOfferProcess1Price() {
        return offerProcess1Price;
    }

    public void setOfferProcess1Price(Float offerProcess1Price) {
        this.offerProcess1Price = offerProcess1Price;
    }

    public Float getOfferProcess2Price() {
        return offerProcess2Price;
    }

    public void setOfferProcess2Price(Float offerProcess2Price) {
        this.offerProcess2Price = offerProcess2Price;
    }

    public Float getOfferProcess3Price() {
        return offerProcess3Price;
    }

    public void setOfferProcess3Price(Float offerProcess3Price) {
        this.offerProcess3Price = offerProcess3Price;
    }

    public Float getOfferProcess4Price() {
        return offerProcess4Price;
    }

    public void setOfferProcess4Price(Float offerProcess4Price) {
        this.offerProcess4Price = offerProcess4Price;
    }

    public Float getOfferProcess5Price() {
        return offerProcess5Price;
    }

    public void setOfferProcess5Price(Float offerProcess5Price) {
        this.offerProcess5Price = offerProcess5Price;
    }

    public String getOfferProcess1Name() {
        return offerProcess1Name;
    }

    public void setOfferProcess1Name(String offerProcess1Name) {
        this.offerProcess1Name = offerProcess1Name;
    }

    public String getOfferProcess2Name() {
        return offerProcess2Name;
    }

    public void setOfferProcess2Name(String offerProcess2Name) {
        this.offerProcess2Name = offerProcess2Name;
    }

    public String getOfferProcess3Name() {
        return offerProcess3Name;
    }

    public void setOfferProcess3Name(String offerProcess3Name) {
        this.offerProcess3Name = offerProcess3Name;
    }

    public String getOfferProcess4Name() {
        return offerProcess4Name;
    }

    public void setOfferProcess4Name(String offerProcess4Name) {
        this.offerProcess4Name = offerProcess4Name;
    }

    public String getOfferProcess5Name() {
        return offerProcess5Name;
    }

    public void setOfferProcess5Name(String offerProcess5Name) {
        this.offerProcess5Name = offerProcess5Name;
    }

    public Float getOfferMachiningPrice() {
        return offerMachiningPrice;
    }

    public void setOfferMachiningPrice(Float offerMachiningPrice) {
        this.offerMachiningPrice = offerMachiningPrice;
    }

    public Float getOfferTotalPrice() {
        return offerTotalPrice;
    }

    public void setOfferTotalPrice(Float offerTotalPrice) {
        this.offerTotalPrice = offerTotalPrice;
    }

}