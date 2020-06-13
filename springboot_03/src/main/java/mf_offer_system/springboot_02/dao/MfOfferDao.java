package mf_offer_system.springboot_02.dao;

import mf_offer_system.springboot_02.entity.MfOffer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 明发报价表(MfOffer)表数据库访问层
 *
 * @author makejava
 * @since 2020-05-09 23:48:09
 */
@Mapper
public interface MfOfferDao {

    /**
     * 通过ID查询单条数据
     *
     * @param offerId 主键
     * @return 实例对象
     */
    MfOffer queryById(Long offerId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<MfOffer> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param mfOffer 实例对象
     * @return 对象列表
     */
    List<MfOffer> queryAll(MfOffer mfOffer);

    /**
     * 新增数据
     *
     * @param mfOffer 实例对象
     * @return 影响行数
     */
    int insert(MfOffer mfOffer);

    /**
     * 修改数据
     *
     * @param mfOffer 实例对象
     * @return 影响行数
     */
    int update(MfOffer mfOffer);

    /**
     * 通过主键删除数据
     *
     * @param offerId 主键
     * @return 影响行数
     */
    int deleteById(Long offerId);

    /**
     * 查询总条数
     * @return
     */
    int queryAllCounts();

    /**
     * 查询完整数据
     * @param offerId
     * @return
     */
    MfOffer queryOfferById(@Param("offerId") Long offerId);

    /**
     * 批量删除
     * @param offers 批量删除的id
     * @return 删除的结构
     */
    Integer deleteByIds(Long[] offers);
}