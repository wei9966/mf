package mf_offer_system.springboot_02.service;

import mf_offer_system.springboot_02.entity.MfOffer;
import mf_offer_system.springboot_02.entity.MfWork;
import mf_offer_system.springboot_02.util.PageUtils;

import java.util.List;

/**
 * 工单表(MfWorkHb)表服务接口
 *
 * @author makejava
 * @since 2020-05-13 23:04:50
 */
public interface MfWorkHbService {

    /**
     * 通过ID查询单条数据
     *
     * @param workId 主键
     * @return 实例对象
     */
    MfWork queryById(Long workId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<MfWork> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param mfWorkHb 实例对象
     * @return 实例对象
     */
    MfWork insert(MfWork mfWorkHb);

    /**
     * 修改数据
     *
     * @param mfWorkHb 实例对象
     * @return 实例对象
     */
    MfWork update(MfWork mfWorkHb);

    /**
     * 通过主键删除数据
     *
     * @param workId 主键
     * @return 是否成功
     */
    boolean deleteById(Long workId);

    Integer insertMfWork(MfWork mfWork, MfOffer mfOffer);

    PageUtils queryByPage(int currentPage, int pageSize);

    MfWork queryDataById(Long workId);

    PageUtils queryByPageGroupByName(int currentPage, int pageSize);

    PageUtils queryByPageByName(int currentPage, int pageSize, String customerName);
}