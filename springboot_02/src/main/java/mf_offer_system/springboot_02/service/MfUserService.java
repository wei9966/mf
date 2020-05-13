package mf_offer_system.springboot_02.service;

import mf_offer_system.springboot_02.entity.MfUser;
import java.util.List;

/**
 * 用户表(MfUser)表服务接口
 *
 * @author makejava
 * @since 2020-05-10 22:39:31
 */
public interface MfUserService {

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    MfUser queryById(Integer userId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<MfUser> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param mfUser 实例对象
     * @return 实例对象
     */
    MfUser insert(MfUser mfUser);

    /**
     * 修改数据
     *
     * @param mfUser 实例对象
     * @return 实例对象
     */
    MfUser update(MfUser mfUser);

    /**
     * 通过主键删除数据
     *
     * @param userId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer userId);

}