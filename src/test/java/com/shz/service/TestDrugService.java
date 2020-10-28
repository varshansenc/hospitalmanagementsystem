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
 * @Date 2020/10/14 21:43
 * @See com.shz.service
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {HMSApplication.class})
public class TestDrugService {

    @Autowired
    private IDrugService drugService;

    @Test
    public void testSelectAllDrug() {
        drugService.selectAllDrug(1, 5, "").forEach(System.out::println);
    }

}
