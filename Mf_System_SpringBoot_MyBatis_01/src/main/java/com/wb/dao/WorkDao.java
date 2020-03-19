package com.wb.dao;

import com.wb.pojo.work.Work;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface WorkDao {
    /**
     * 添加工单进入数据库
     *
     * @param work
     * @return
     */
    @Insert("insert into t_producework values (default,#{w_kDate},#{w_cName},#{w_pName},#{w_count},#{w_jDate},#{w_hDate},#{w_jiTai},#{w_cSize},#{w_pSize},#{w_fmPage},#{w_fmKb},#{w_fmZcount},#{w_fmFcount},#{w_fmHcount},#{w_fmYellow},#{w_fmYCount},#{w_nxPage},#{w_nxKb},#{w_nxZcount},#{w_nxFcount},#{w_nxHcount},#{w_nxYellow},#{w_nxYCount},#{w_cyPage},#{w_cyKb},#{w_cyZcount},#{w_cyFcount},#{w_cyHcount},#{w_cyYellow},#{w_cyYCount},#{w_other},#{w_hjg},#{w_fmKs},#{w_nxKs},#{w_cyKs},#{w_result},#{w_flag});")
    int insWork(Work work);

    /**
     * 分页查询所有工单
     *
     * @param start
     * @param size
     * @return
     */
    @Select("select * from t_producework  order by w_id desc limit #{arg0},#{arg1};")
    List<Work> selAllWork(int start, int size);

    /**
     * 查询总条数
     *
     * @return
     */
    @Select(" select count(*) from t_producework;")
    int selAllWorkCount();

    //    更新生产和未生产
    @Update("  update bjjl set pFlag=2 where id=#{arg0};")
    int updateProduct(int flag);

    //   书刊生产
    @Update("update hcbj set hflag=2  where hbjjl=#{arg0};")
    int updateHc(int flag);

    //   画册生产
    @Update("update skbj set s_flag=2  where s_bjjl=#{arg0};")
    int updateSk(int flag);

    @Update("update t_producework set w_id=#{arg1}" +
            "        <if test=\"w_kDate != '' and w_kDate != null\">" +
            "          , w_kDate=#{w_kDate}" +
            "        </if>" +
            "        <if test=\"w_cName != '' and w_cName != null\">" +
            "            , w_cName=#{w_cName}" +
            "        </if>" +
            "        <if test=\"w_pName != '' and w_pName != null\">" +
            "            , w_pName=#{w_pName}" +
            "        </if>" +
            "        <if test=\"w_hjg != '' and w_hjg != null\">" +
            "            , w_hjg=#{w_hjg}" +
            "        </if>" +
            "        <if test=\"w_result != '' and w_result != 0\">" +
            "            , w_result=#{w_result}" +
            "        </if>" +
            "        <if test=\"w_other != '' and w_other != null\">" +
            "            , w_other=#{w_other}" +
            "        </if>" +
            "      where w_id=#{arg1};")
    int updateWork(@Param("w_kDate") String w_kDate, int id, @Param("w_cName") String w_cName, @Param("w_pName") String w_pName, @Param("w_hjg") String w_hjg, @Param("w_result") double w_result, @Param("w_other") String w_other);
}
