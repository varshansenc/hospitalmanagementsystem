package com.shz.service.impl;

import com.github.pagehelper.PageHelper;
import com.shz.dao.ILogDao;
import com.shz.entity.Log;
import com.shz.service.ILogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description
 * @Author shz
 * @Date 2020/10/16 10:21
 * @See com.shz.service.impl
 */
@Service
@Transactional
public class LogServiceImpl implements ILogService {

    @Autowired
    private ILogDao logDao;

    @Override
    public void insertLog(Log log) {
        logDao.insert(log);
    }

    @Override
    public List<Log> selectAllLog(Integer currentPage, Integer everyPage, String name, Integer type) {
        PageHelper.startPage(currentPage, everyPage);
        return logDao.selectAllLog(name, type);
//        if(type == 0) {                                 // 登录日志
//            return logDao.selectAllLog(name, 0);
//        } else if (type == 1) {                         // 诊断日志
//            return logDao.selectAllLog(name, 1);
//        } else {
//            return null;
//        }
    }
}
