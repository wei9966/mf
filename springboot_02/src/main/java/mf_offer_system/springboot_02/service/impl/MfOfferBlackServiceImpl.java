package mf_offer_system.springboot_02.service.impl;

import mf_offer_system.springboot_02.dao.MfOfferBlackDao;
import mf_offer_system.springboot_02.entity.MfOffer;
import mf_offer_system.springboot_02.service.MfOfferBlackService;
import mf_offer_system.springboot_02.util.PageUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 明发报价表黑白(MfOfferBlack)表服务实现类
 *
 * @author makejava
 * @since 2020-05-11 22:27:52
 */
@Service("mfOfferBlackService")
public class MfOfferBlackServiceImpl implements MfOfferBlackService {
    @Resource
    private MfOfferBlackDao mfOfferBlackDao;

    /**
     * 通过ID查询单条数据
     *
     * @param offerId 主键
     * @return 实例对象
     */
    @Override
    public MfOffer queryById(Long offerId) {
        return this.mfOfferBlackDao.queryById(offerId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<MfOffer> queryAllByLimit(int offset, int limit) {
        return this.mfOfferBlackDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param mfOfferBlack 实例对象
     * @return 实例对象
     */
    @Override
    public MfOffer insert(MfOffer mfOfferBlack) {
        this.mfOfferBlackDao.insert(mfOfferBlack);
        return mfOfferBlack;
    }

    /**
     * 修改数据
     *
     * @param mfOfferBlack 实例对象
     * @return 实例对象
     */
    @Override
    public MfOffer update(MfOffer mfOfferBlack) {
        this.mfOfferBlackDao.update(mfOfferBlack);
        return this.queryById(mfOfferBlack.getOfferId());
    }

    /**
     * 通过主键删除数据
     *
     * @param offerId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long offerId) {
        return this.mfOfferBlackDao.deleteById(offerId) > 0;
    }

    @Override
    public PageUtils queryByPage(int currentPage, int pageSize) {
        int offest = (currentPage - 1) * pageSize;
        //获取数据
        List<MfOffer> mfOffers = mfOfferBlackDao.queryAllByLimit(offest, pageSize);
        //计算出总条数
        int counts = mfOfferBlackDao.queryAllCounts();
        PageUtils pageUtils = new PageUtils(mfOffers, counts, pageSize, currentPage);
        System.out.println("分页数据" + pageUtils);
        return pageUtils;
    }

    @Override
    public MfOffer queryOfferById(Long offerId) {
        return mfOfferBlackDao.queryOfferById(offerId);
    }
}