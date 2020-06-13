package mf_offer_system.springboot_02.service.impl;

import mf_offer_system.springboot_02.entity.MfMachine;
import mf_offer_system.springboot_02.dao.MfMachineDao;
import mf_offer_system.springboot_02.service.MfMachineService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 机台(MfMachine)表服务实现类
 *
 * @author makejava
 * @since 2020-05-13 20:36:21
 */
@Service("mfMachineService")
public class MfMachineServiceImpl implements MfMachineService {
    @Resource
    private MfMachineDao mfMachineDao;

    /**
     * 通过ID查询单条数据
     *
     * @param machineId 主键
     * @return 实例对象
     */
    @Override
    public MfMachine queryById(Integer machineId) {
        return this.mfMachineDao.queryById(machineId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<MfMachine> queryAllByLimit(int offset, int limit) {
        return this.mfMachineDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param mfMachine 实例对象
     * @return 实例对象
     */
    @Override
    public MfMachine insert(MfMachine mfMachine) {
        this.mfMachineDao.insert(mfMachine);
        return mfMachine;
    }

    /**
     * 修改数据
     *
     * @param mfMachine 实例对象
     * @return 实例对象
     */
    @Override
    public MfMachine update(MfMachine mfMachine) {
        this.mfMachineDao.update(mfMachine);
        return this.queryById(mfMachine.getMachineId());
    }

    /**
     * 通过主键删除数据
     *
     * @param machineId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer machineId) {
        return this.mfMachineDao.deleteById(machineId) > 0;
    }
}