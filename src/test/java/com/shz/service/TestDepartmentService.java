package com.shz.service;

import com.shz.HMSApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Description
 * @Author shz
 * @Date 2020/10/12 21:03
 * @See com.shz.service
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {HMSApplication.class})
public class TestDepartmentService {

    @Autowired
    private IDepartmentService departmentService;

    @Test
    public void testSelectAll() {
        System.out.println(departmentService.selectAllDepartments(1, 2, null));
    }

}
