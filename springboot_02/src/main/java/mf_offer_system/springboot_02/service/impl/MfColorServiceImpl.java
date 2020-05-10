package mf_offer_system.springboot_02.service.impl;

import mf_offer_system.springboot_02.entity.MfColor;
import mf_offer_system.springboot_02.dao.MfColorDao;
import mf_offer_system.springboot_02.service.MfColorService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 墨色表(MfColor)表服务实现类
 *
 * @author makejava
 * @since 2020-05-09 20:48:24
 */
@Service("mfColorService")
public class MfColorServiceImpl implements MfColorService {
    @Resource
    private MfColorDao mfColorDao;

    /**
     * 通过ID查询单条数据
     *
     * @param colorId 主键
     * @return 实例对象
     */
    @Override
    public MfColor queryById(Integer colorId) {
        return this.mfColorDao.queryById(colorId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<MfColor> queryAllByLimit(int offset, int limit) {
        return this.mfColorDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param mfColor 实例对象
     * @return 实例对象
     */
    @Override
    public MfColor insert(MfColor mfColor) {
        this.mfColorDao.insert(mfColor);
        return mfColor;
    }

    /**
     * 修改数据
     *
     * @param mfColor 实例对象
     * @return 实例对象
     */
    @Override
    public MfColor update(MfColor mfColor) {
        this.mfColorDao.update(mfColor);
        return this.queryById(mfColor.getColorId());
    }

    /**
     * 通过主键删除数据
     *
     * @param colorId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer colorId) {
        return this.mfColorDao.deleteById(colorId) > 0;
    }
}