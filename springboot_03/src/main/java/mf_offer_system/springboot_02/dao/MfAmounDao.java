package mf_offer_system.springboot_02.dao;

import mf_offer_system.springboot_02.entity.MfAmoun;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 复膜(MfAmoun)表数据库访问层
 *
 * @author makejava
 * @since 2020-05-09 23:48:23
 */
@Mapper
public interface MfAmounDao {

    /**
     * 通过ID查询单条数据
     *
     * @param amounId 主键
     * @return 实例对象
     */
    MfAmoun queryById(Integer amounId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<MfAmoun> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param mfAmoun 实例对象
     * @return 对象列表
     */
    List<MfAmoun> queryAll(MfAmoun mfAmoun);

    /**
     * 新增数据
     *
     * @param mfAmoun 实例对象
     * @return 影响行数
     */
    int insert(MfAmoun mfAmoun);

    /**
     * 修改数据
     *
     * @param mfAmoun 实例对象
     * @return 影响行数
     */
    int update(MfAmoun mfAmoun);

    /**
     * 通过主键删除数据
     *
     * @param amounId 主键
     * @return 影响行数
     */
    int deleteById(Integer amounId);

}