package mf_offer_system.springboot_02.service;

import mf_offer_system.springboot_02.entity.MfAmoun;
import java.util.List;

/**
 * 复膜(MfAmoun)表服务接口
 *
 * @author makejava
 * @since 2020-05-09 23:48:23
 */
public interface MfAmounService {

    /**
     * 通过ID查询单条数据
     *
     * @param amounId 主键
     * @return 实例对象
     */
    MfAmoun queryById(Integer amounId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<MfAmoun> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param mfAmoun 实例对象
     * @return 实例对象
     */
    MfAmoun insert(MfAmoun mfAmoun);

    /**
     * 修改数据
     *
     * @param mfAmoun 实例对象
     * @return 实例对象
     */
    MfAmoun update(MfAmoun mfAmoun);

    /**
     * 通过主键删除数据
     *
     * @param amounId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer amounId);

}