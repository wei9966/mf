package mf_offer_system.springboot_02.service.impl;

import mf_offer_system.springboot_02.entity.MfType;
import mf_offer_system.springboot_02.dao.MfTypeDao;
import mf_offer_system.springboot_02.service.MfTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 报价类型表(MfType)表服务实现类
 *
 * @author makejava
 * @since 2020-05-09 20:51:18
 */
@Service("mfTypeService")
public class MfTypeServiceImpl implements MfTypeService {
    @Resource
    private MfTypeDao mfTypeDao;

    /**
     * 通过ID查询单条数据
     *
     * @param typeId 主键
     * @return 实例对象
     */
    @Override
    public MfType queryById(Integer typeId) {
        return this.mfTypeDao.queryById(typeId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<MfType> queryAllByLimit(int offset, int limit) {
        return this.mfTypeDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param mfType 实例对象
     * @return 实例对象
     */
    @Override
    public MfType insert(MfType mfType) {
        this.mfTypeDao.insert(mfType);
        return mfType;
    }

    /**
     * 修改数据
     *
     * @param mfType 实例对象
     * @return 实例对象
     */
    @Override
    public MfType update(MfType mfType) {
        this.mfTypeDao.update(mfType);
        return this.queryById(mfType.getTypeId());
    }

    /**
     * 通过主键删除数据
     *
     * @param typeId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer typeId) {
        return this.mfTypeDao.deleteById(typeId) > 0;
    }
}