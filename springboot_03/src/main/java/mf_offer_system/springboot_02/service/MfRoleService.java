package mf_offer_system.springboot_02.service;

import mf_offer_system.springboot_02.entity.MfRole;
import java.util.List;

/**
 * 角色表(MfRole)表服务接口
 *
 * @author makejava
 * @since 2020-05-10 22:56:48
 */
public interface MfRoleService {

    /**
     * 通过ID查询单条数据
     *
     * @param roleId 主键
     * @return 实例对象
     */
    MfRole queryById(Integer roleId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<MfRole> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param mfRole 实例对象
     * @return 实例对象
     */
    MfRole insert(MfRole mfRole);

    /**
     * 修改数据
     *
     * @param mfRole 实例对象
     * @return 实例对象
     */
    MfRole update(MfRole mfRole);

    /**
     * 通过主键删除数据
     *
     * @param roleId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer roleId);

}