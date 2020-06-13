package mf_offer_system.springboot_02.service;

import mf_offer_system.springboot_02.entity.MfBingding;
import java.util.List;

/**
 * 装订方式(MfBingding)表服务接口
 *
 * @author makejava
 * @since 2020-05-09 23:48:31
 */
public interface MfBingdingService {

    /**
     * 通过ID查询单条数据
     *
     * @param bindingId 主键
     * @return 实例对象
     */
    MfBingding queryById(Integer bindingId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<MfBingding> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param mfBingding 实例对象
     * @return 实例对象
     */
    MfBingding insert(MfBingding mfBingding);

    /**
     * 修改数据
     *
     * @param mfBingding 实例对象
     * @return 实例对象
     */
    MfBingding update(MfBingding mfBingding);

    /**
     * 通过主键删除数据
     *
     * @param bindingId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer bindingId);

}