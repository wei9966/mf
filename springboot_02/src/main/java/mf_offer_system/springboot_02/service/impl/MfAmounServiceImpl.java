package mf_offer_system.springboot_02.service.impl;

import mf_offer_system.springboot_02.entity.MfAmoun;
import mf_offer_system.springboot_02.dao.MfAmounDao;
import mf_offer_system.springboot_02.service.MfAmounService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 复膜(MfAmoun)表服务实现类
 *
 * @author makejava
 * @since 2020-05-09 23:48:23
 */
@Service("mfAmounService")
public class MfAmounServiceImpl implements MfAmounService {
    @Resource
    private MfAmounDao mfAmounDao;

    /**
     * 通过ID查询单条数据
     *
     * @param amounId 主键
     * @return 实例对象
     */
    @Override
    public MfAmoun queryById(Integer amounId) {
        return this.mfAmounDao.queryById(amounId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<MfAmoun> queryAllByLimit(int offset, int limit) {
        return this.mfAmounDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param mfAmoun 实例对象
     * @return 实例对象
     */
    @Override
    public MfAmoun insert(MfAmoun mfAmoun) {
        this.mfAmounDao.insert(mfAmoun);
        return mfAmoun;
    }

    /**
     * 修改数据
     *
     * @param mfAmoun 实例对象
     * @return 实例对象
     */
    @Override
    public MfAmoun update(MfAmoun mfAmoun) {
        this.mfAmounDao.update(mfAmoun);
        return this.queryById(mfAmoun.getAmounId());
    }

    /**
     * 通过主键删除数据
     *
     * @param amounId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer amounId) {
        return this.mfAmounDao.deleteById(amounId) > 0;
    }
}