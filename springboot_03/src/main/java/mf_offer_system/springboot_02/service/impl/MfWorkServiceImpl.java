package mf_offer_system.springboot_02.service.impl;

import mf_offer_system.springboot_02.dao.MfOfferDao;
import mf_offer_system.springboot_02.dao.MfWorkDao;
import mf_offer_system.springboot_02.entity.MfOffer;
import mf_offer_system.springboot_02.entity.MfWork;
import mf_offer_system.springboot_02.service.MfWorkService;
import mf_offer_system.springboot_02.util.PageUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 工单表(MfWork)表服务实现类
 *
 * @author makejava
 * @since 2020-05-13 11:56:43
 */
@Service("mfWorkService")
public class MfWorkServiceImpl implements MfWorkService {
    @Resource
    private MfWorkDao mfWorkDao;
    @Resource
    private MfOfferDao mfOfferDao;

    /**
     * 通过ID查询单条数据
     *
     * @param workId 主键
     * @return 实例对象
     */
    @Override
    public MfWork queryById(Long workId) {
        return this.mfWorkDao.queryById(workId);
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
        return this.mfWorkDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param mfWork 实例对象
     * @return 实例对象
     */
    @Override
    public MfWork insert(MfWork mfWork) {
        this.mfWorkDao.insert(mfWork);
        return mfWork;
    }

    /**
     * 修改数据
     *
     * @param mfWork 实例对象
     * @return 实例对象
     */
    @Override
    public MfWork update(MfWork mfWork) {
        this.mfWorkDao.update(mfWork);
        return this.queryById(mfWork.getWorkId());
    }

    /**
     * 通过主键删除数据
     *
     * @param workId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long workId) {
        return this.mfWorkDao.deleteById(workId) > 0;
    }

    @Override
    public PageUtils queryByPage(int currentPage, int pageSize) {
        int offest = (currentPage - 1) * pageSize;
        //获取数据
        List<MfWork> mfWorks = mfWorkDao.queryAllDataByLimit(offest, pageSize);
        //计算出总条数
        int counts = mfWorkDao.queryAllWorkCounts();
        PageUtils pageUtils = new PageUtils(mfWorks, counts, pageSize, currentPage);
        System.out.println("分页数据" + pageUtils);
        return pageUtils;
    }

    @Override
    public int insertMfWork(MfWork mfWork, MfOffer mfOffer) {
        //更新生产记录
        //更新前先判断一下这个工单是否有被生产
        if (mfOfferDao.queryById(mfOffer.getOfferId()).getOfferProduceId() == 1) {
            return 0;
        }
        int update = mfOfferDao.update(mfOffer);
        //新增工单
        int insert = mfWorkDao.insert(mfWork);
        return 1;
    }

    @Override
    public MfWork queryDataById(Long workId) {
        return mfWorkDao.queryDataByWorkId(workId);
    }

    @Override
    public PageUtils queryByPageGroupByName(int currentPage, int pageSize) {
        int offest = (currentPage - 1) * pageSize;
        //获取数据
        List<MfWork> mfWorks = mfWorkDao.queryByPageGroupByName(offest, pageSize);
        //计算出总条数
        int counts = mfWorkDao.queryAllWorkCountsGroupByName();
        PageUtils pageUtils = new PageUtils(mfWorks, counts, pageSize, currentPage);
        System.out.println("分页数据" + pageUtils);
        return pageUtils;
    }

    @Override
    public PageUtils queryByPageByName(int currentPage, int pageSize, String customerName) {
        int offest = (currentPage - 1) * pageSize;
        //获取数据
        List<MfWork> mfWorks = mfWorkDao.queryByPageByName(offest, pageSize, customerName);
        //计算出总条数
        int counts = mfWorkDao.queryAllWorkCountsByName(customerName);
        PageUtils pageUtils = new PageUtils(mfWorks, counts, pageSize, currentPage);
        System.out.println("分页数据" + pageUtils);
        return pageUtils;
    }
}