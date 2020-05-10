package mf_offer_system.springboot_02.service;

import mf_offer_system.springboot_02.entity.MfColor;
import java.util.List;

/**
 * 墨色表(MfColor)表服务接口
 *
 * @author makejava
 * @since 2020-05-09 20:48:23
 */
public interface MfColorService {

    /**
     * 通过ID查询单条数据
     *
     * @param colorId 主键
     * @return 实例对象
     */
    MfColor queryById(Integer colorId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<MfColor> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param mfColor 实例对象
     * @return 实例对象
     */
    MfColor insert(MfColor mfColor);

    /**
     * 修改数据
     *
     * @param mfColor 实例对象
     * @return 实例对象
     */
    MfColor update(MfColor mfColor);

    /**
     * 通过主键删除数据
     *
     * @param colorId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer colorId);

}