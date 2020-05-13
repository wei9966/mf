package mf_offer_system.springboot_02.dao;

import mf_offer_system.springboot_02.entity.MfRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 角色表(MfRole)表数据库访问层
 *
 * @author makejava
 * @since 2020-05-10 22:56:48
 */
@Mapper
public interface MfRoleDao {

    /**
     * 通过ID查询单条数据
     *
     * @param roleId 主键
     * @return 实例对象
     */
    MfRole queryById(Integer roleId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<MfRole> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param mfRole 实例对象
     * @return 对象列表
     */
    List<MfRole> queryAll(MfRole mfRole);

    /**
     * 新增数据
     *
     * @param mfRole 实例对象
     * @return 影响行数
     */
    int insert(MfRole mfRole);

    /**
     * 修改数据
     *
     * @param mfRole 实例对象
     * @return 影响行数
     */
    int update(MfRole mfRole);

    /**
     * 通过主键删除数据
     *
     * @param roleId 主键
     * @return 影响行数
     */
    int deleteById(Integer roleId);

}