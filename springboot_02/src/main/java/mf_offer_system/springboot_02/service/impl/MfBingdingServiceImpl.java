package mf_offer_system.springboot_02.service.impl;

import mf_offer_system.springboot_02.entity.MfBingding;
import mf_offer_system.springboot_02.dao.MfBingdingDao;
import mf_offer_system.springboot_02.service.MfBingdingService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 装订方式(MfBingding)表服务实现类
 *
 * @author makejava
 * @since 2020-05-09 23:48:31
 */
@Service("mfBingdingService")
public class MfBingdingServiceImpl implements MfBingdingService {
    @Resource
    private MfBingdingDao mfBingdingDao;

    /**
     * 通过ID查询单条数据
     *
     * @param bindingId 主键
     * @return 实例对象
     */
    @Override
    public MfBingding queryById(Integer bindingId) {
        return this.mfBingdingDao.queryById(bindingId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<MfBingding> queryAllByLimit(int offset, int limit) {
        return this.mfBingdingDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param mfBingding 实例对象
     * @return 实例对象
     */
    @Override
    public MfBingding insert(MfBingding mfBingding) {
        this.mfBingdingDao.insert(mfBingding);
        return mfBingding;
    }

    /**
     * 修改数据
     *
     * @param mfBingding 实例对象
     * @return 实例对象
     */
    @Override
    public MfBingding update(MfBingding mfBingding) {
        this.mfBingdingDao.update(mfBingding);
        return this.queryById(mfBingding.getBindingId());
    }

    /**
     * 通过主键删除数据
     *
     * @param bindingId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer bindingId) {
        return this.mfBingdingDao.deleteById(bindingId) > 0;
    }
}