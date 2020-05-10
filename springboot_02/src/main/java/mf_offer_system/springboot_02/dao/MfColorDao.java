package mf_offer_system.springboot_02.dao;

import mf_offer_system.springboot_02.entity.MfColor;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 墨色表(MfColor)表数据库访问层
 *
 * @author makejava
 * @since 2020-05-09 20:48:23
 */
@Mapper
public interface MfColorDao {

    /**
     * 通过ID查询单条数据
     *
     * @param colorId 主键
     * @return 实例对象
     */
    MfColor queryById(Integer colorId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<MfColor> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param mfColor 实例对象
     * @return 对象列表
     */
    List<MfColor> queryAll(MfColor mfColor);

    /**
     * 新增数据
     *
     * @param mfColor 实例对象
     * @return 影响行数
     */
    int insert(MfColor mfColor);

    /**
     * 修改数据
     *
     * @param mfColor 实例对象
     * @return 影响行数
     */
    int update(MfColor mfColor);

    /**
     * 通过主键删除数据
     *
     * @param colorId 主键
     * @return 影响行数
     */
    int deleteById(Integer colorId);

}