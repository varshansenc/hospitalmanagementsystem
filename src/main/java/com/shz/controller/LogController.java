package com.shz.controller;

import com.github.pagehelper.PageInfo;
import com.shz.entity.Log;
import com.shz.entity.ResultVo;
import com.shz.service.ILogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Description
 * @Author shz
 * @Date 2020/10/18 9:49
 * @See com.shz.controller
 */
@Controller
@RequestMapping("log")
public class LogController {

    @Autowired
    private ILogService logService;

    @RequestMapping("selectAllLog")
    @ResponseBody
    public ResultVo selectAllLog(Integer currentPage, Integer everyPage, String name, Integer type) {
        List<Log> logList = logService.selectAllLog(currentPage, everyPage, name, type);
        PageInfo<Log> pageInfo = new PageInfo<>(logList);
        return new ResultVo(pageInfo.getTotal(), pageInfo.getList());
    }

    @RequestMapping("selectAllLoginLog")
    @ResponseBody
    public ResultVo selectAllLoginLog(Integer currentPage, Integer everyPage, String name, Integer type) {
        List<Log> logList = logService.selectAllLog(currentPage, everyPage, name, 0);
        PageInfo<Log> pageInfo = new PageInfo<>(logList);
        return new ResultVo(pageInfo.getTotal(), pageInfo.getList());
    }

    @RequestMapping("selectAllAdviceLog")
    @ResponseBody
    public ResultVo selectAllAdviceLog(Integer currentPage, Integer everyPage, String name, Integer type) {
        List<Log> logList = logService.selectAllLog(currentPage, everyPage, name, 1);
        PageInfo<Log> pageInfo = new PageInfo<>(logList);
        return new ResultVo(pageInfo.getTotal(), pageInfo.getList());
    }

}
