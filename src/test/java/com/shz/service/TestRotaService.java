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
 * @Date 2020/10/13 9:43
 * @See com.shz.service
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {HMSApplication.class})
public class TestRotaService {

    @Autowired
    private IRotaService rotaService;

    @Test
    public void testSelectAll() {
        rotaService.selectAllRota(1,10).forEach(e -> {
            System.out.println(e);
            System.out.println(e.getDepartment());
            System.out.println(e.getUser());
        });
    }

}
