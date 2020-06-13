package mf_offer_system.springboot_02.service.impl;

import mf_offer_system.springboot_02.dao.MfOfferBlackDao;
import mf_offer_system.springboot_02.dao.MfWorkHbDao;
import mf_offer_system.springboot_02.entity.MfOffer;
import mf_offer_system.springboot_02.entity.MfWork;
import mf_offer_system.springboot_02.service.MfWorkHbService;
import mf_offer_system.springboot_02.util.PageUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 工单表(MfWorkHb)表服务实现类
 *
 * @author makejava
 * @since 2020-05-13 23:04:50
 */
@Service("mfWorkHbService")
public class MfWorkHbServiceImpl implements MfWorkHbService {
    @Resource
    private MfWorkHbDao mfWorkHbDao;
    @Resource
    private MfOfferBlackDao mfOfferBlackDao;

    /**
     * 通过ID查询单条数据
     *
     * @param workId 主键
     * @return 实例对象
     */
    @Override
    public MfWork queryById(Long workId) {
        return this.mfWorkHbDao.queryById(workId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<MfWork> queryAllByLimit(int offset, int limit) {
        return this.mfWorkHbDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param mfWorkHb 实例对象
     * @return 实例对象
     */
    @Override
    public MfWork insert(MfWork mfWorkHb) {
        this.mfWorkHbDao.insert(mfWorkHb);
        return mfWorkHb;
    }

    /**
     * 修改数据
     *
     * @param mfWorkHb 实例对象
     * @return 实例对象
     */
    @Override
    public MfWork update(MfWork mfWorkHb) {
        this.mfWorkHbDao.update(mfWorkHb);
        return this.queryById(mfWorkHb.getWorkId());
    }

    /**
     * 通过主键删除数据
     *
     * @param workId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long workId) {
        return this.mfWorkHbDao.deleteById(workId) > 0;
    }

    @Override
    public PageUtils queryByPage(int currentPage, int pageSize) {
        int offest = (currentPage - 1) * pageSize;
        //获取数据
        List<MfWork> mfWorks = mfWorkHbDao.queryAllByLimit(offest, pageSize);
        //计算出总条数
        int counts = mfWorkHbDao.queryAllWorkHbCounts();
        PageUtils pageUtils = new PageUtils(mfWorks, counts, pageSize, currentPage);
        System.out.println("分页数据" + pageUtils);
        return pageUtils;
    }

    @Override
    public Integer insertMfWork(MfWork mfWork, MfOffer mfOffer) {
        if (mfOfferBlackDao.queryById(mfOffer.getOfferId()).getOfferProduceId() == 1) {
            return 0;
        }
        //更新生产记录
        int update = mfOfferBlackDao.update(mfOffer);
        //新增工单
        int insert = mfWorkHbDao.insert(mfWork);
        return 1;
    }

    @Override
    public MfWork queryDataById(Long workId) {

        return  mfWorkHbDao.queryDataHbByWorkId(workId);
    }

    @Override
    public PageUtils queryByPageGroupByName(int currentPage, int pageSize) {
        int offest = (currentPage - 1) * pageSize;
        //获取数据
        List<MfWork> mfWorks = mfWorkHbDao.queryByPageGroupByName(offest, pageSize);
        //计算出总条数
        int counts = mfWorkHbDao.queryAllWorkCountsGroupByName();
        PageUtils pageUtils = new PageUtils(mfWorks, counts, pageSize, currentPage);
        System.out.println("分页数据" + pageUtils);
        return pageUtils;
    }

    @Override
    public PageUtils queryByPageByName(int currentPage, int pageSize, String customerName) {
        int offest = (currentPage - 1) * pageSize;
        //获取数据
        List<MfWork> mfWorks = mfWorkHbDao.queryByPageByName(offest, pageSize, customerName);
        //计算出总条数
        int counts = mfWorkHbDao.queryAllWorkCountsByName(customerName);
        PageUtils pageUtils = new PageUtils(mfWorks, counts, pageSize, currentPage);
        System.out.println("分页数据" + pageUtils);
        return pageUtils;
    }
}