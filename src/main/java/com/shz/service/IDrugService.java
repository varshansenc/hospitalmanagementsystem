package com.shz.service;

import com.shz.entity.Drug;

import java.util.List;

/**
 * @Description
 * @Author shz
 * @Date 2020/10/14 21:37
 * @See com.shz.service
 */
public interface IDrugService {

    /**
    * @Description 查询药品
    * @Author shz
    * @Date 2020/10/14 21:37
    * 
    * @Param currentPage
	* @Param everyPage
	* @Param name
    * @Return: java.util.List<com.shz.entity.Drug>
    **/
    List<Drug> selectAllDrug(Integer currentPage, Integer everyPage, String name);

    /**
    * @Description 添加药品
    * @Author shz
    * @Date 2020/10/14 22:08
    *
    * @Param drug
    * @Return: int
    **/
    int insertDrug(Drug drug);

    /**
    * @Description 修改药品信息
    * @Author shz
    * @Date 2020/10/14 22:48
    * 
    * @Param drug
    * @Return: int
    **/
    int updateDrug(Drug drug);

    /**
    * @Description 删除药品
    * @Author shz
    * @Date 2020/10/15 9:29
    * 
    * @Param id
    * @Return: int
    **/
    int delDrugById(Integer id);
}
