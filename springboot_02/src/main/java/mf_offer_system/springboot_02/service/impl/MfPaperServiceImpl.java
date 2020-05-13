package mf_offer_system.springboot_02.service.impl;

import mf_offer_system.springboot_02.entity.MfPaper;
import mf_offer_system.springboot_02.dao.MfPaperDao;
import mf_offer_system.springboot_02.service.MfPaperService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 纸张类型(MfPaper)表服务实现类
 *
 * @author makejava
 * @since 2020-05-09 20:50:39
 */
@Service("mfPaperService")
public class MfPaperServiceImpl implements MfPaperService {
    @Resource
    private MfPaperDao mfPaperDao;

    /**
     * 通过ID查询单条数据
     *
     * @param paperId 主键
     * @return 实例对象
     */
    @Override
    public MfPaper queryById(Integer paperId) {
        return this.mfPaperDao.queryById(paperId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<MfPaper> queryAllByLimit(int offset, int limit) {
        return this.mfPaperDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param mfPaper 实例对象
     * @return 实例对象
     */
    @Override
    public MfPaper insert(MfPaper mfPaper) {
        this.mfPaperDao.insert(mfPaper);
        return mfPaper;
    }

    /**
     * 修改数据
     *
     * @param mfPaper 实例对象
     * @return 实例对象
     */
    @Override
    public MfPaper update(MfPaper mfPaper) {
        this.mfPaperDao.update(mfPaper);
        return this.queryById(mfPaper.getPaperId());
    }

    /**
     * 通过主键删除数据
     *
     * @param paperId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer paperId) {
        return this.mfPaperDao.deleteById(paperId) > 0;
    }

    @Override
    public int getKaiBie(int paperId) {
        MfPaper mfPaper = mfPaperDao.queryById(paperId);
        return Integer.valueOf(mfPaper.getPaperType().substring(mfPaper.getPaperType().indexOf("度")+1,mfPaper.getPaperType().indexOf("开")))/2;
    }
}