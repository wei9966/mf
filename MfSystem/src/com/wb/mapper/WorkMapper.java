package com.wb.mapper;

import com.wb.pojo.work.Work;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WorkMapper {
   /**
    * 添加工单进入数据库
    * @param work
    * @return
    */
   int insWork(Work work);

   /**
    * 分页查询所有工单
    * @param start
    * @param size
    * @return
    */
   List<Work> selAllWork(int start,int size);

   /**
    * 查询总条数
    * @return
    */
   int selAllWorkCount();
   //    更新生产和未生产
   int updateProduct(int flag);

//   书刊生产
   int updateHc(int flag);
//   画册生产
int updateSk(int flag);
   int updateWork(@Param("w_kDate") String w_kDate, int id,@Param("w_cName") String w_cName,@Param("w_pName") String w_pName,@Param("w_hjg") String w_hjg,@Param("w_result") double w_result,@Param("w_other") String w_other);
}
