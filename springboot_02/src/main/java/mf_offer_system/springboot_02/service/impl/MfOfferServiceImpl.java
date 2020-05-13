package mf_offer_system.springboot_02.service.impl;

import mf_offer_system.springboot_02.entity.MfOffer;
import mf_offer_system.springboot_02.dao.MfOfferDao;
import mf_offer_system.springboot_02.service.MfOfferService;
import mf_offer_system.springboot_02.util.PageUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 明发报价表(MfOffer)表服务实现类
 *
 * @author makejava
 * @since 2020-05-09 23:48:09
 */
@Service("mfOfferService")
public class MfOfferServiceImpl implements MfOfferService {
    @Resource
    private MfOfferDao mfOfferDao;

    /**
     * 通过ID查询单条数据
     *
     * @param offerId 主键
     * @return 实例对象
     */
    @Override
    public MfOffer queryById(Long offerId) {
        return this.mfOfferDao.queryById(offerId);
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

        return this.mfOfferDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param mfOffer 实例对象
     * @return 实例对象
     */
    @Override
    public MfOffer insert(MfOffer mfOffer) {
        this.mfOfferDao.insert(mfOffer);
        return mfOffer;
    }

    /**
     * 修改数据
     *
     * @param mfOffer 实例对象
     * @return 实例对象
     */
    @Override
    public MfOffer update(MfOffer mfOffer) {
        this.mfOfferDao.update(mfOffer);
        return this.queryById(mfOffer.getOfferId());
    }

    /**
     * 通过主键删除数据
     *
     * @param offerId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long offerId) {
        return this.mfOfferDao.deleteById(offerId) > 0;
    }

    @Override
    public PageUtils queryByPage(int currentPage, int pageSize) {
        int offest = (currentPage - 1) * pageSize;
        //获取数据
        List<MfOffer> mfOffers = mfOfferDao.queryAllByLimit(offest, pageSize);
        //计算出总条数
        int counts = mfOfferDao.queryAllCounts();
        PageUtils pageUtils = new PageUtils(mfOffers, counts, pageSize, currentPage);
        System.out.println("分页数据"+pageUtils);
        return pageUtils;
    }

    @Override
    public MfOffer queryOfferById(Long offerId) {
        return mfOfferDao.queryOfferById(offerId);
    }
}