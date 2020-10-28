package com.shz.service.impl;

import com.github.pagehelper.PageHelper;
import com.shz.dao.IExamDao;
import com.shz.entity.Exam;
import com.shz.service.IExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description
 * @Author shz
 * @Date 2020/10/15 13:01
 * @See com.shz.service.impl
 */
@Service
@Transactional
public class ExamServiceImpl implements IExamService {

    @Autowired
    private IExamDao examDao;

    @Override
    public int insertExam(Exam exam) {
        return examDao.insert(exam);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Exam> selectAllExamDrug(Integer currentPage, Integer everyPage, String name) {
        PageHelper.startPage(currentPage, everyPage);
        return examDao.selectAllExamDrug(name);
    }

    @Override
    public int updateExam(Exam exam) {
        return examDao.updateExamById(exam);
    }
}
