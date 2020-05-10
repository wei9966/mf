package mf_offer_system.springboot_02.service;

import mf_offer_system.springboot_02.entity.MfType;
import java.util.List;

/**
 * 报价类型表(MfType)表服务接口
 *
 * @author makejava
 * @since 2020-05-09 20:51:18
 */
public interface MfTypeService {

    /**
     * 通过ID查询单条数据
     *
     * @param typeId 主键
     * @return 实例对象
     */
    MfType queryById(Integer typeId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<MfType> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param mfType 实例对象
     * @return 实例对象
     */
    MfType insert(MfType mfType);

    /**
     * 修改数据
     *
     * @param mfType 实例对象
     * @return 实例对象
     */
    MfType update(MfType mfType);

    /**
     * 通过主键删除数据
     *
     * @param typeId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer typeId);

}