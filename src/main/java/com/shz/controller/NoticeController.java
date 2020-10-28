package com.shz.controller;

import com.github.pagehelper.PageInfo;
import com.shz.entity.Notice;
import com.shz.entity.ResultVo;
import com.shz.service.INoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Description
 * @Author shz
 * @Date 2020/10/13 11:26
 * @See com.shz.controller
 */
@Controller
@RequestMapping("notice")
public class NoticeController {

    @Autowired
    private INoticeService noticeService;

    @RequestMapping("selectAllNotice")
    @ResponseBody
    public ResultVo selectAllNotice(Integer currentPage, Integer everyPage) {
        List<Notice> noticeList = noticeService.selectAllNotice(currentPage, everyPage);
        PageInfo<Notice> pageInfo = new PageInfo<>(noticeList);
        return new ResultVo(pageInfo.getTotal(), pageInfo.getList());
    }

}
