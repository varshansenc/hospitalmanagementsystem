package com.shz.service;

import com.shz.entity.Log;

import java.util.List;

/**
 * @Description
 * @Author shz
 * @Date 2020/10/16 10:19
 * @See com.shz.service
 */
public interface ILogService {

    /**
    * @Description 添加日志
    * @Author shz
    * @Date 2020/10/16 10:21
    *
    * @Param log
    * @Return: void
    **/
    void insertLog(Log log);

    /**
    * @Description 查询所有日志
    * @Author shz
    * @Date 2020/10/18 9:57
    *
    * @Param currentPage
	* @Param everyPage
	* @Param name
	* @Param type
    * @Return: java.util.List<com.shz.entity.Log>
    **/
    List<Log> selectAllLog(Integer currentPage, Integer everyPage, String name, Integer type);
}
