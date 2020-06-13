package mf_offer_system.springboot_02.service.impl;

import mf_offer_system.springboot_02.dao.MfRunningBillDao;
import mf_offer_system.springboot_02.entity.MfRunningBill;
import mf_offer_system.springboot_02.service.MfRunningBillService;
import mf_offer_system.springboot_02.util.PageUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 明发流水表(MfRunningBill)表服务实现类
 *
 * @author makejava
 * @since 2020-05-28 11:47:14
 */
@Service("mfRunningBillService")
public class MfRunningBillServiceImpl implements MfRunningBillService {
    @Resource
    private MfRunningBillDao mfRunningBillDao;

    /**
     * 通过ID查询单条数据
     *
     * @param billId 主键
     * @return 实例对象
     */
    @Override
    public MfRunningBill queryById(Integer billId) {
        return this.mfRunningBillDao.queryById(billId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<MfRunningBill> queryAllByLimit(int offset, int limit) {
        return this.mfRunningBillDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param mfRunningBill 实例对象
     * @return 实例对象
     */
    @Override
    public MfRunningBill insert(MfRunningBill mfRunningBill) {
        this.mfRunningBillDao.insert(mfRunningBill);
        return mfRunningBill;
    }

    /**
     * 修改数据
     *
     * @param mfRunningBill 实例对象
     * @return 实例对象
     */
    @Override
    public MfRunningBill update(MfRunningBill mfRunningBill) {
        this.mfRunningBillDao.update(mfRunningBill);
        return this.queryById(mfRunningBill.getBillId());
    }

    /**
     * 通过主键删除数据
     *
     * @param billId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer billId) {
        return this.mfRunningBillDao.deleteById(billId) > 0;
    }

    @Override
    public PageUtils queryByPage(int currentPage, int pageSize) {
        int offest = (currentPage - 1) * pageSize;
        //获取数据
        List<MfRunningBill> mfRunningBlackBills = mfRunningBillDao.queryAllByLimit(offest, pageSize);
        //计算出总条数
        int counts = mfRunningBillDao.queryAllCounts();
        PageUtils pageUtils = new PageUtils(mfRunningBlackBills, counts, pageSize, currentPage);
        System.out.println("分页数据"+pageUtils);
        return pageUtils;
    }
}