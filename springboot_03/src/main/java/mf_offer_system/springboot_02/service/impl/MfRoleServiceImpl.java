package mf_offer_system.springboot_02.service.impl;

import mf_offer_system.springboot_02.entity.MfRole;
import mf_offer_system.springboot_02.dao.MfRoleDao;
import mf_offer_system.springboot_02.service.MfRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 角色表(MfRole)表服务实现类
 *
 * @author makejava
 * @since 2020-05-10 22:56:48
 */
@Service("mfRoleService")
public class MfRoleServiceImpl implements MfRoleService {
    @Resource
    private MfRoleDao mfRoleDao;

    /**
     * 通过ID查询单条数据
     *
     * @param roleId 主键
     * @return 实例对象
     */
    @Override
    public MfRole queryById(Integer roleId) {
        return this.mfRoleDao.queryById(roleId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<MfRole> queryAllByLimit(int offset, int limit) {
        return this.mfRoleDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param mfRole 实例对象
     * @return 实例对象
     */
    @Override
    public MfRole insert(MfRole mfRole) {
        this.mfRoleDao.insert(mfRole);
        return mfRole;
    }

    /**
     * 修改数据
     *
     * @param mfRole 实例对象
     * @return 实例对象
     */
    @Override
    public MfRole update(MfRole mfRole) {
        this.mfRoleDao.update(mfRole);
        return this.queryById(mfRole.getRoleId());
    }

    /**
     * 通过主键删除数据
     *
     * @param roleId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer roleId) {
        return this.mfRoleDao.deleteById(roleId) > 0;
    }
}