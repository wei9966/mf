package mf_offer_system.springboot_02.dao;

import mf_offer_system.springboot_02.entity.MfCollage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 拼版尺寸(MfCollage)表数据库访问层
 *
 * @author makejava
 * @since 2020-05-15 10:58:29
 */
@Mapper
public interface MfCollageDao {

    /**
     * 通过ID查询单条数据
     *
     * @param collageId 主键
     * @return 实例对象
     */
    MfCollage queryById(Integer collageId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<MfCollage> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param mfCollage 实例对象
     * @return 对象列表
     */
    List<MfCollage> queryAll(MfCollage mfCollage);

    /**
     * 新增数据
     *
     * @param mfCollage 实例对象
     * @return 影响行数
     */
    int insert(MfCollage mfCollage);

    /**
     * 修改数据
     *
     * @param mfCollage 实例对象
     * @return 影响行数
     */
    int update(MfCollage mfCollage);

    /**
     * 通过主键删除数据
     *
     * @param collageId 主键
     * @return 影响行数
     */
    int deleteById(Integer collageId);

}