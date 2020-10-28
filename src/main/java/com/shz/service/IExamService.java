package com.shz.service;

import com.shz.entity.Exam;

import java.util.List;

/**
 * @Description
 * @Author shz
 * @Date 2020/10/15 12:59
 * @See com.shz.service
 */
public interface IExamService {
    /**
    * @Description 提交审核
    * @Author shz
    * @Date 2020/10/15 13:00
    *
    * @Param exam
    * @Return: int
    **/
    int insertExam(Exam exam);

    /**
    * @Description 查询药品审核
    * @Author shz
    * @Date 2020/10/16 8:15
    *
    * @Param currentPage
	* @Param everyPage
	* @Param name
    * @Return: java.util.List<com.shz.entity.Exam>
    **/
    List<Exam> selectAllExamDrug(Integer currentPage, Integer everyPage, String name);

    /**
    * @Description 审核药品
    * @Author shz
    * @Date 2020/10/16 9:23
    * 
    * @Param exam
    * @Return: int
    **/
    int updateExam(Exam exam);
}
