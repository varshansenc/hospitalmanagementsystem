package com.shz.service.impl;

import com.github.pagehelper.PageHelper;
import com.shz.dao.INoticeDao;
import com.shz.entity.Notice;
import com.shz.service.INoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description
 * @Author shz
 * @Date 2020/10/13 19:14
 * @See com.shz.service.impl
 */
@Service
@Transactional
public class NoticeServiceImpl implements INoticeService {

    @Autowired
    private INoticeDao noticeDao;

    @Override
    @Transactional(readOnly = true)
    public List<Notice> selectAllNotice(Integer currentPage, Integer everyPage) {
        PageHelper.startPage(currentPage, everyPage);
        return noticeDao.selectList(null);
    }
}
