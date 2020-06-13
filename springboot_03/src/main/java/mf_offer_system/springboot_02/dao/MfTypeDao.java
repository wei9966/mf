package mf_offer_system.springboot_02.dao;

import mf_offer_system.springboot_02.entity.MfType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 报价类型表(MfType)表数据库访问层
 *
 * @author makejava
 * @since 2020-05-09 20:51:18
 */
@Mapper
public interface MfTypeDao {

    /**
     * 通过ID查询单条数据
     *
     * @param typeId 主键
     * @return 实例对象
     */
    MfType queryById(Integer typeId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<MfType> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param mfType 实例对象
     * @return 对象列表
     */
    List<MfType> queryAll(MfType mfType);

    /**
     * 新增数据
     *
     * @param mfType 实例对象
     * @return 影响行数
     */
    int insert(MfType mfType);

    /**
     * 修改数据
     *
     * @param mfType 实例对象
     * @return 影响行数
     */
    int update(MfType mfType);

    /**
     * 通过主键删除数据
     *
     * @param typeId 主键
     * @return 影响行数
     */
    int deleteById(Integer typeId);

}