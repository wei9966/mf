package mf_offer_system.springboot_02.service;

import mf_offer_system.springboot_02.entity.MfPaper;
import java.util.List;

/**
 * 纸张类型(MfPaper)表服务接口
 *
 * @author makejava
 * @since 2020-05-09 20:50:39
 */
public interface MfPaperService {

    /**
     * 通过ID查询单条数据
     *
     * @param paperId 主键
     * @return 实例对象
     */
    MfPaper queryById(Integer paperId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<MfPaper> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param mfPaper 实例对象
     * @return 实例对象
     */
    MfPaper insert(MfPaper mfPaper);

    /**
     * 修改数据
     *
     * @param mfPaper 实例对象
     * @return 实例对象
     */
    MfPaper update(MfPaper mfPaper);

    /**
     * 通过主键删除数据
     *
     * @param paperId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer paperId);

    int getKaiBie(int paperId);
}