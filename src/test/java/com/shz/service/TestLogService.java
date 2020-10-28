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
 * @Date 2020/10/18 10:09
 * @See com.shz.service
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {HMSApplication.class})
public class TestLogService {

    @Autowired
    private ILogService logService;

    @Test
    public void testSelectAllLog() {
        logService.selectAllLog(1, 10, "张飞", 0).forEach(System.out::println);
    }
}
