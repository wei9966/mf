package mf_offer_system.springboot_02.service.impl;

import mf_offer_system.springboot_02.dao.MfPaperDao;
import mf_offer_system.springboot_02.entity.MfOffer;
import mf_offer_system.springboot_02.entity.MfPaper;
import mf_offer_system.springboot_02.entity.MfTonprice;
import mf_offer_system.springboot_02.dao.MfTonpriceDao;
import mf_offer_system.springboot_02.service.MfTonpriceService;
import mf_offer_system.springboot_02.util.ConstantUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 吨价表(MfTonprice)表服务实现类
 *
 * @author makejava
 * @since 2020-05-09 20:51:09
 */
@Service("mfTonpriceService")
public class MfTonpriceServiceImpl implements MfTonpriceService {

    @Resource
    private MfTonpriceDao mfTonpriceDao;

    @Resource
    private MfPaperDao mfPaperDao;

    /**
     * 通过ID查询单条数据
     *
     * @param tpId 主键
     * @return 实例对象
     */
    @Override
    public MfTonprice queryById(Integer tpId) {
        return this.mfTonpriceDao.queryById(tpId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<MfTonprice> queryAllByLimit(int offset, int limit) {
        return this.mfTonpriceDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param mfTonprice 实例对象
     * @return 实例对象
     */
    @Override
    public MfTonprice insert(MfTonprice mfTonprice) {
        this.mfTonpriceDao.insert(mfTonprice);
        return mfTonprice;
    }

    /**
     * 修改数据
     *
     * @param mfTonprice 实例对象
     * @return 实例对象
     */
    @Override
    public MfTonprice update(MfTonprice mfTonprice) {
        this.mfTonpriceDao.update(mfTonprice);
        return this.queryById(mfTonprice.getTpId());
    }

    /**
     * 通过主键删除数据
     *
     * @param tpId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer tpId) {
        return this.mfTonpriceDao.deleteById(tpId) > 0;
    }

    /**
     * @param mfOffer 报价单
     * @param type    看是封面还是内芯或者插页
     * @return 单价
     */
    @Override
    public double countSinglePaper(MfOffer mfOffer, int type) {
        //吨价/
        //先根据纸型获取当前报价的纸的类型的吨价
        MfTonprice mfTonprice = null;
        //根据尺寸获取尺寸变量
        MfPaper mfPaper = mfPaperDao.queryById(mfOffer.getSizeId());
        //根据传进来的尺寸判断时大度还是正度
        //令的常量
        int order;
        if (mfPaper.getPaperType().contains(ConstantUtil.SIZE_TYPE_BIG)) {
            order = ConstantUtil.TON_PRICE_LING_BIG;
        } else {
            order = ConstantUtil.TON_PRICE_LING_NOMAL;
        }
        Integer grammage = 0;
        switch (type) {
            case 1:
                grammage = mfOffer.getOfferCoverGrammage();
                mfTonprice=mfTonpriceDao.queryById(mfOffer.getPaperIdCover());
                break;
            case 2:
                grammage = mfOffer.getOfferCoreGrammage();
                mfTonprice=mfTonpriceDao.queryById(mfOffer.getPaperIdCore());
                break;
            case 3:
                grammage = mfOffer.getOfferInsetGrammage();
                mfTonprice=mfTonpriceDao.queryById(mfOffer.getPaperIdInset());
                break;
            default:
                break;
        }
        return mfTonprice.getTpPrice() / order * grammage / 500;
    }
}