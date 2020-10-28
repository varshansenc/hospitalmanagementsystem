package com.shz.service;

import com.shz.entity.Notice;

import java.util.List;

/**
 * @Description
 * @Author shz
 * @Date 2020/10/13 19:12
 * @See com.shz.service
 */
public interface INoticeService {
    /**
    * @Description 查询通知
    * @Author shz
    * @Date 2020/10/13 19:14
    * 
    * @Param currentPage
	* @Param everyPage
    * @Return: java.util.List<com.shz.entity.Notice>
    **/
    List<Notice> selectAllNotice(Integer currentPage, Integer everyPage);

}
