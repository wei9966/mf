package mf_offer_system.springboot_02.dao;

import mf_offer_system.springboot_02.entity.MfWork;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 工单表(MfWorkHb)表数据库访问层
 *
 * @author makejava
 * @since 2020-05-13 23:04:50
 */
@Mapper
public interface MfWorkHbDao {

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
     * @param limit 查询条数
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

    /**
     * 查询总条数
     * @return 总条数
     */
    int queryAllWorkHbCounts();

    /**
     * 查询所有的工单
     * @param offset 起始
     * @param limit 分页
     * @return
     */
    List<MfWork> queryAllDataHbByLimit(@Param("offset") int offset, @Param("limit") int limit);

    /**
     * 通过id查询完整数据
     * @param workId 工单id
     * @return
     */
    MfWork queryDataHbByWorkId(Long workId);

    List<MfWork> queryByPageGroupByName(@Param("offest") int offset, @Param("limit") int limit);

    int queryAllWorkCountsGroupByName();

    List<MfWork> queryByPageByName(int offest, int pageSize, String customerName);

    int queryAllWorkCountsByName(String customerName);
}