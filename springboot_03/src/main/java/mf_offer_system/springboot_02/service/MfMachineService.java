package mf_offer_system.springboot_02.service;

import mf_offer_system.springboot_02.entity.MfMachine;
import java.util.List;

/**
 * 机台(MfMachine)表服务接口
 *
 * @author makejava
 * @since 2020-05-13 20:36:21
 */
public interface MfMachineService {

    /**
     * 通过ID查询单条数据
     *
     * @param machineId 主键
     * @return 实例对象
     */
    MfMachine queryById(Integer machineId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<MfMachine> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param mfMachine 实例对象
     * @return 实例对象
     */
    MfMachine insert(MfMachine mfMachine);

    /**
     * 修改数据
     *
     * @param mfMachine 实例对象
     * @return 实例对象
     */
    MfMachine update(MfMachine mfMachine);

    /**
     * 通过主键删除数据
     *
     * @param machineId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer machineId);

}