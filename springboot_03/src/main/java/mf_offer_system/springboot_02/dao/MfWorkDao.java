package mf_offer_system.springboot_02.dao;

import mf_offer_system.springboot_02.entity.MfWork;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 工单表(MfWork)表数据库访问层
 *
 * @author makejava
 * @since 2020-05-13 11:56:43
 */
@Mapper
public interface MfWorkDao {

    /**
     * 通过ID查询单条数据
     *
     * @param workId 主键
     * @return 实例对象
     */
    MfWork queryById(Long workId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<MfWork> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param mfWork 实例对象
     * @return 对象列表
     */
    List<MfWork> queryAll(MfWork mfWork);

    /**
     * 新增数据
     *
     * @param mfWork 实例对象
     * @return 影响行数
     */
    int insert(MfWork mfWork);

    /**
     * 修改数据
     *
     * @param mfWork 实例对象
     * @return 影响行数
     */
    int update(MfWork mfWork);

    /**
     * 通过主键删除数据
     *
     * @param workId 主键
     * @return 影响行数
     */
    int deleteById(Long workId);

    int queryAllWorkCounts();

    List<MfWork> queryAllDataByLimit(@Param("offest") int offest, @Param("limit") int limit);

    /**
     * 通过id查询完整数据
     *
     * @param workId id
     * @return 查询的结果
     */
    MfWork queryDataByWorkId(Long workId);

    List<MfWork> queryByPageGroupByName(@Param("offest") int offest, @Param("limit") int pageSize);

    int queryAllWorkCountsGroupByName();

    List<MfWork> queryByPageByName(@Param("offest") int offest, @Param("limit") int pageSize, @Param("customerName") String customerName);

    int queryAllWorkCountsByName(@Param("customerName") String customerName);
}