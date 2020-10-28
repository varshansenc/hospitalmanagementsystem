package com.shz.service;

import com.shz.HMSApplication;
import com.shz.entity.Exam;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Description
 * @Author shz
 * @Date 2020/10/16 8:23
 * @See com.shz.service
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {HMSApplication.class})
public class TestExamService {

    @Autowired
    private IExamService examService;

    @Test
    public void testSelectAll() {
        examService.selectAllExamDrug(1,5, "宝宝").forEach(e -> {
            System.out.println(e);
            System.out.println(e.getDrug());
        });
    }

    @Test
    public void exam() {
        examService.updateExam(new Exam(1, 1, "111", null, null, null));
    }

}
