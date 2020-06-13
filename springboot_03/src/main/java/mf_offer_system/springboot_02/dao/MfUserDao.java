package mf_offer_system.springboot_02.dao;

import mf_offer_system.springboot_02.entity.MfUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 用户表(MfUser)表数据库访问层
 *
 * @author makejava
 * @since 2020-05-10 22:39:31
 */
@Mapper
public interface MfUserDao {

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    MfUser queryById(Integer userId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<MfUser> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param mfUser 实例对象
     * @return 对象列表
     */
    List<MfUser> queryAll(MfUser mfUser);

    /**
     * 新增数据
     *
     * @param mfUser 实例对象
     * @return 影响行数
     */
    int insert(MfUser mfUser);

    /**
     * 修改数据
     *
     * @param mfUser 实例对象
     * @return 影响行数
     */
    int update(MfUser mfUser);

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 影响行数
     */
    int deleteById(Integer userId);

}