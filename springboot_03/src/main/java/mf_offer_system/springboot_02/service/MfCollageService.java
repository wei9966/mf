package mf_offer_system.springboot_02.service;

import mf_offer_system.springboot_02.entity.MfCollage;
import java.util.List;

/**
 * 拼版尺寸(MfCollage)表服务接口
 *
 * @author makejava
 * @since 2020-05-15 10:58:29
 */
public interface MfCollageService {

    /**
     * 通过ID查询单条数据
     *
     * @param collageId 主键
     * @return 实例对象
     */
    MfCollage queryById(Integer collageId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<MfCollage> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param mfCollage 实例对象
     * @return 实例对象
     */
    MfCollage insert(MfCollage mfCollage);

    /**
     * 修改数据
     *
     * @param mfCollage 实例对象
     * @return 实例对象
     */
    MfCollage update(MfCollage mfCollage);

    /**
     * 通过主键删除数据
     *
     * @param collageId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer collageId);

}