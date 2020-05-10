package mf_offer_system.springboot_02.dao;

import mf_offer_system.springboot_02.entity.MfTonprice;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 吨价表(MfTonprice)表数据库访问层
 *
 * @author makejava
 * @since 2020-05-09 20:51:08
 */
@Mapper
public interface MfTonpriceDao {

    /**
     * 通过ID查询单条数据
     *
     * @param tpId 主键
     * @return 实例对象
     */
    MfTonprice queryById(Integer tpId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<MfTonprice> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param mfTonprice 实例对象
     * @return 对象列表
     */
    List<MfTonprice> queryAll(MfTonprice mfTonprice);

    /**
     * 新增数据
     *
     * @param mfTonprice 实例对象
     * @return 影响行数
     */
    int insert(MfTonprice mfTonprice);

    /**
     * 修改数据
     *
     * @param mfTonprice 实例对象
     * @return 影响行数
     */
    int update(MfTonprice mfTonprice);

    /**
     * 通过主键删除数据
     *
     * @param tpId 主键
     * @return 影响行数
     */
    int deleteById(Integer tpId);

}