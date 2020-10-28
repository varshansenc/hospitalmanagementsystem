package com.shz.service;

import com.shz.entity.User;

/**
 * @Description
 * @Author shz
 * @Date 2020/10/14 8:48
 * @See com.shz.service
 */
public interface IUserService {

    /**
    * @Description 根据用户名查询用户
    * @Author shz
    * @Date 2020/10/14 8:49
    * 
    * @Param username
    * @Return: com.shz.entity.User
    **/
    User selectUserByUsername(String username);
}
