package mf_offer_system.springboot_02.service.impl;

import mf_offer_system.springboot_02.entity.MfCollage;
import mf_offer_system.springboot_02.dao.MfCollageDao;
import mf_offer_system.springboot_02.service.MfCollageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 拼版尺寸(MfCollage)表服务实现类
 *
 * @author makejava
 * @since 2020-05-15 10:58:29
 */
@Service("mfCollageService")
public class MfCollageServiceImpl implements MfCollageService {
    @Resource
    private MfCollageDao mfCollageDao;

    /**
     * 通过ID查询单条数据
     *
     * @param collageId 主键
     * @return 实例对象
     */
    @Override
    public MfCollage queryById(Integer collageId) {
        return this.mfCollageDao.queryById(collageId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<MfCollage> queryAllByLimit(int offset, int limit) {
        return this.mfCollageDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param mfCollage 实例对象
     * @return 实例对象
     */
    @Override
    public MfCollage insert(MfCollage mfCollage) {
        this.mfCollageDao.insert(mfCollage);
        return mfCollage;
    }

    /**
     * 修改数据
     *
     * @param mfCollage 实例对象
     * @return 实例对象
     */
    @Override
    public MfCollage update(MfCollage mfCollage) {
        this.mfCollageDao.update(mfCollage);
        return this.queryById(mfCollage.getCollageId());
    }

    /**
     * 通过主键删除数据
     *
     * @param collageId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer collageId) {
        return this.mfCollageDao.deleteById(collageId) > 0;
    }
}