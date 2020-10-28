package com.shz.controller;

import com.github.pagehelper.PageInfo;
import com.shz.entity.Exam;
import com.shz.entity.ResultVo;
import com.shz.service.IExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * @Description
 * @Author shz
 * @Date 2020/10/15 12:57
 * @See com.shz.controller
 */
@Controller
@RequestMapping("exam")
public class ExamController {

    @Autowired
    private IExamService examService;

    @RequestMapping("addExam")
    @ResponseBody
    public ResultVo addExam(Integer examStatus, Integer did) {
        Exam exam = new Exam();
        exam.setExamStartDate(new Date());
        exam.setExamStatus(examStatus);
        exam.setDid(did);
        int count = examService.insertExam(exam);
        return new ResultVo(0, "审核提交成功", (long) count, null);
    }

    @RequestMapping("selectAllExamDrug")
    @ResponseBody
    public ResultVo selectAllExamDrug(Integer currentPage, Integer everyPage, String name) {
        List<Exam> examDrugList = examService.selectAllExamDrug(currentPage, everyPage, name);
        PageInfo<Exam> pageInfo = new PageInfo<>(examDrugList);
        return new ResultVo(pageInfo.getTotal(), pageInfo.getList());
    }

    @RequestMapping("updateExam")
    @ResponseBody
    public ResultVo updateExam(Exam exam) {
        int count = examService.updateExam(exam);
        return new ResultVo((long) count, null);
    }

}
