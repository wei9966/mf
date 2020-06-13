package mf_offer_system.springboot_02.service;

import mf_offer_system.springboot_02.entity.MfRunningBill;
import mf_offer_system.springboot_02.util.PageUtils;

import java.util.List;

/**
 * 明发流水表(MfRunningBill)表服务接口
 *
 * @author makejava
 * @since 2020-05-28 11:47:14
 */
public interface MfRunningBillService {

    /**
     * 通过ID查询单条数据
     *
     * @param billId 主键
     * @return 实例对象
     */
    MfRunningBill queryById(Integer billId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<MfRunningBill> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param mfRunningBill 实例对象
     * @return 实例对象
     */
    MfRunningBill insert(MfRunningBill mfRunningBill);

    /**
     * 修改数据
     *
     * @param mfRunningBill 实例对象
     * @return 实例对象
     */
    MfRunningBill update(MfRunningBill mfRunningBill);

    /**
     * 通过主键删除数据
     *
     * @param billId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer billId);

    PageUtils queryByPage(int currentPage, int pageSize);
}