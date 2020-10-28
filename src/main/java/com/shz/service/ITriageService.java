package com.shz.service;

import com.shz.entity.Triage;
import com.shz.entity.TriageVo;

import java.util.List;

/**
 * @Description
 * @Author shz
 * @Date 2020/10/13 20:06
 * @See com.shz.service
 */
public interface ITriageService {

    /**
    * @Description 添加分诊信息
    * @Author shz
    * @Date 2020/10/13 20:07
    *
    * @Param triage
    * @Return: int
    **/
    int addTriage(Triage triage);

    /**
    * @Description 查询所有分诊信息
    * @Author shz
    * @Date 2020/10/13 21:02
    *
    * @Return: java.util.List<com.shz.entity.TriageVo>
    **/
    List<TriageVo> selectAllTriage();

    /**
    * @Description 根据科室id查询分诊信息
    * @Author shz
    * @Date 2020/10/13 21:43
    *
    * @Param currentPage
	* @Param everyPage
	* @Param id
    * @Return java.util.List<com.shz.entity.Triage>
    **/
    List<Triage> selectTriageByDId(Integer currentPage, Integer everyPage, Integer id);

    /**
    * @Description 修改分诊状态
    * @Author shz
    * @Date 2020/10/13 22:28
    *
    * @Param tid
    * @Param status
    * @Return: int
    **/
    int updateTriageStatus(Integer tid, Integer status);

    /**
    * @Description 根据id查询分诊信息
    * @Author shz
    * @Date 2020/10/14 20:30
    *
    * @Param tid
    * @Return com.shz.entity.TriageVo
    **/
    TriageVo selectTriageByTId(Integer tid);

    /**
    * @Description 诊断
    * @Author shz
    * @Date 2020/10/14 21:17
    *
    * @Param triage
    * @Return: int
    **/
    int updateTriage(Triage triage);
}
