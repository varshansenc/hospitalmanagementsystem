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
 * @Date 2020/10/13 22:12
 * @See com.shz.service
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {HMSApplication.class})
public class TestTriageService {

    @Autowired
    private ITriageService triageService;

    @Test
    public void testSelectByDid() {
        triageService.selectTriageByDId(1, 5, 1).forEach(e -> {
            System.out.println(e);
            System.out.println(e.getPatient());
        });
    }

}
