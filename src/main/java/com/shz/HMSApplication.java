package com.shz;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Description
 * @Author shz
 * @Date 2020/10/12 19:06
 * @See com.shz
 */
@SpringBootApplication
@MapperScan(value = {"com.shz.dao"})
public class HMSApplication {

    public static void main(String[] args) {
        SpringApplication.run(HMSApplication.class, args);
    }

}
