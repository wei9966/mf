package mf_offer_system.springboot_02.dao;

import mf_offer_system.springboot_02.entity.MfRunningBill;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 明发黑白流水表(MfRunningBillBlack)表数据库访问层
 *
 * @author makejava
 * @since 2020-06-07 16:41:23
 */
@Mapper
public interface MfRunningBillBlackDao {

    /**
     * 通过ID查询单条数据
     *
     * @param billId 主键
     * @return 实例对象
     */
    MfRunningBill queryById(Integer billId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<MfRunningBill> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param mfRunningBillBlack 实例对象
     * @return 对象列表
     */
    List<MfRunningBill> queryAll(MfRunningBill mfRunningBillBlack);

    /**
     * 新增数据
     *
     * @param mfRunningBillBlack 实例对象
     * @return 影响行数
     */
    int insert(MfRunningBill mfRunningBillBlack);

    /**
     * 修改数据
     *
     * @param mfRunningBillBlack 实例对象
     * @return 影响行数
     */
    int update(MfRunningBill mfRunningBillBlack);

    /**
     * 通过主键删除数据
     *
     * @param billId 主键
     * @return 影响行数
     */
    int deleteById(Integer billId);

    int queryAllBlackCounts();
}