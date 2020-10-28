package com.shz.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shz.entity.Exam;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description
 * @Author shz
 * @Date 2020/10/15 13:02
 * @See com.shz.dao
 */
@Repository
public interface IExamDao extends BaseMapper<Exam> {

    /**
    * @Description 查询药品审核信息
    * @Author shz
    * @Date 2020/10/16 8:16
    *
    * @Param name
    * @Return java.util.List<com.shz.entity.Exam>
    **/
    List<Exam> selectAllExamDrug(String name);

    /**
    * @Description 修改审核状态和审核意见
    * @Author shz
    * @Date 2020/10/16 9:24
    * 
    * @Param exam
    * @Return: int
    **/
    int updateExamById(Exam exam);
}
