package mf_offer_system.springboot_02.service;

import mf_offer_system.springboot_02.entity.MfOffer;
import mf_offer_system.springboot_02.entity.MfTonprice;

import java.util.List;

/**
 * 吨价表(MfTonprice)表服务接口
 *
 * @author makejava
 * @since 2020-05-09 20:51:09
 */
public interface MfTonpriceService {

    /**
     * 通过ID查询单条数据
     *
     * @param tpId 主键
     * @return 实例对象
     */
    MfTonprice queryById(Integer tpId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<MfTonprice> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param mfTonprice 实例对象
     * @return 实例对象
     */
    MfTonprice insert(MfTonprice mfTonprice);

    /**
     * 修改数据
     *
     * @param mfTonprice 实例对象
     * @return 实例对象
     */
    MfTonprice update(MfTonprice mfTonprice);

    /**
     * 通过主键删除数据
     *
     * @param tpId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer tpId);

     double  countSinglePaper(MfOffer mfOffer, int type);
}