package mf_offer_system.springboot_02.service.impl;

import mf_offer_system.springboot_02.entity.MfTonprice;
import mf_offer_system.springboot_02.dao.MfTonpriceDao;
import mf_offer_system.springboot_02.service.MfTonpriceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 吨价表(MfTonprice)表服务实现类
 *
 * @author makejava
 * @since 2020-05-09 20:51:09
 */
@Service("mfTonpriceService")
public class MfTonpriceServiceImpl implements MfTonpriceService {
    @Resource
    private MfTonpriceDao mfTonpriceDao;

    /**
     * 通过ID查询单条数据
     *
     * @param tpId 主键
     * @return 实例对象
     */
    @Override
    public MfTonprice queryById(Integer tpId) {
        return this.mfTonpriceDao.queryById(tpId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<MfTonprice> queryAllByLimit(int offset, int limit) {
        return this.mfTonpriceDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param mfTonprice 实例对象
     * @return 实例对象
     */
    @Override
    public MfTonprice insert(MfTonprice mfTonprice) {
        this.mfTonpriceDao.insert(mfTonprice);
        return mfTonprice;
    }

    /**
     * 修改数据
     *
     * @param mfTonprice 实例对象
     * @return 实例对象
     */
    @Override
    public MfTonprice update(MfTonprice mfTonprice) {
        this.mfTonpriceDao.update(mfTonprice);
        return this.queryById(mfTonprice.getTpId());
    }

    /**
     * 通过主键删除数据
     *
     * @param tpId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer tpId) {
        return this.mfTonpriceDao.deleteById(tpId) > 0;
    }
}