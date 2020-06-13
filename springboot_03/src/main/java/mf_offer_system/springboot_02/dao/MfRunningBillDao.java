package mf_offer_system.springboot_02.dao;

import mf_offer_system.springboot_02.entity.MfRunningBill;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 明发流水表(MfRunningBill)表数据库访问层
 *
 * @author makejava
 * @since 2020-06-07 16:39:47
 */
@Mapper
public interface MfRunningBillDao {

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
     * @param mfRunningBill 实例对象
     * @return 对象列表
     */
    List<MfRunningBill> queryAll(MfRunningBill mfRunningBill);

    /**
     * 新增数据
     *
     * @param mfRunningBill 实例对象
     * @return 影响行数
     */
    int insert(MfRunningBill mfRunningBill);

    /**
     * 修改数据
     *
     * @param mfRunningBill 实例对象
     * @return 影响行数
     */
    int update(MfRunningBill mfRunningBill);

    /**
     * 通过主键删除数据
     *
     * @param billId 主键
     * @return 影响行数
     */
    int deleteById(Integer billId);

    int queryAllCounts();
}