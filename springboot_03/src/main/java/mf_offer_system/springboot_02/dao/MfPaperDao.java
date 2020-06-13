package mf_offer_system.springboot_02.dao;

import mf_offer_system.springboot_02.entity.MfPaper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 纸张类型(MfPaper)表数据库访问层
 *
 * @author makejava
 * @since 2020-05-09 20:50:39
 */
@Mapper
public interface MfPaperDao {

    /**
     * 通过ID查询单条数据
     *
     * @param paperId 主键
     * @return 实例对象
     */
    MfPaper queryById(Integer paperId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<MfPaper> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param mfPaper 实例对象
     * @return 对象列表
     */
    List<MfPaper> queryAll(MfPaper mfPaper);

    /**
     * 新增数据
     *
     * @param mfPaper 实例对象
     * @return 影响行数
     */
    int insert(MfPaper mfPaper);

    /**
     * 修改数据
     *
     * @param mfPaper 实例对象
     * @return 影响行数
     */
    int update(MfPaper mfPaper);

    /**
     * 通过主键删除数据
     *
     * @param paperId 主键
     * @return 影响行数
     */
    int deleteById(Integer paperId);

}