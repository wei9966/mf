package mf_offer_system.springboot_02.service;

import mf_offer_system.springboot_02.entity.MfOffer;
import mf_offer_system.springboot_02.util.PageUtils;

import java.util.List;

/**
 * 明发报价表黑白(MfOfferBlack)表服务接口
 *
 * @author makejava
 * @since 2020-05-11 22:27:52
 */
public interface MfOfferBlackService {

    /**
     * 通过ID查询单条数据
     *
     * @param offerId 主键
     * @return 实例对象
     */
    MfOffer queryById(Long offerId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<MfOffer> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param mfOfferBlack 实例对象
     * @return 实例对象
     */
    MfOffer insert(MfOffer mfOfferBlack);

    /**
     * 修改数据
     *
     * @param mfOfferBlack 实例对象
     * @return 实例对象
     */
    MfOffer update(MfOffer mfOfferBlack);

    /**
     * 通过主键删除数据
     *
     * @param offerId 主键
     * @return 是否成功
     */
    boolean deleteById(Long offerId);

    /**
     * 分页查询
     * @param currentPage 当前页面
     * @param pageSize 显示条数
     * @return 分页结果
     */
    PageUtils queryByPage(int currentPage, int pageSize);

    /**
     * 根据offerid查询报价
     * @param offerId 报价id
     * @return 查询出来的报价
     */
    MfOffer queryOfferById(Long offerId);

    /**
     * 根据id批量删除
     * @param offers 批量id
     * @return 删除结果
     */
    boolean deleteByIds(Long[] offers);
}