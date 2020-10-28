package com.shz.service;

import com.shz.entity.Rota;

import java.util.List;

/**
 * @Description
 * @Author shz
 * @Date 2020/10/13 9:07
 * @See com.shz.service
 */
public interface IRotaService {

    /**
    * @Description 查询所有值班信息
    * @Author shz
    * @Date 2020/10/13 9:07
    * 
    * @Param currentPage
	* @Param everyPage
    * @Return: java.util.List<com.shz.entity.Rota>
    **/
    List<Rota> selectAllRota(Integer currentPage, Integer everyPage);
}
