package mf_offer_system.springboot_02.dao;

import mf_offer_system.springboot_02.entity.MfBingding;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 装订方式(MfBingding)表数据库访问层
 *
 * @author makejava
 * @since 2020-05-09 23:48:31
 */
@Mapper
public interface MfBingdingDao {

    /**
     * 通过ID查询单条数据
     *
     * @param bindingId 主键
     * @return 实例对象
     */
    MfBingding queryById(Integer bindingId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<MfBingding> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param mfBingding 实例对象
     * @return 对象列表
     */
    List<MfBingding> queryAll(MfBingding mfBingding);

    /**
     * 新增数据
     *
     * @param mfBingding 实例对象
     * @return 影响行数
     */
    int insert(MfBingding mfBingding);

    /**
     * 修改数据
     *
     * @param mfBingding 实例对象
     * @return 影响行数
     */
    int update(MfBingding mfBingding);

    /**
     * 通过主键删除数据
     *
     * @param bindingId 主键
     * @return 影响行数
     */
    int deleteById(Integer bindingId);

}