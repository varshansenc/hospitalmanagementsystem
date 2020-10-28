package com.shz.service.impl;

import com.shz.dao.IUserDao;
import com.shz.entity.User;
import com.shz.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

/**
 * @Description
 * @Author shz
 * @Date 2020/10/14 8:48
 * @See com.shz.service.impl
 */
@Service
@Transactional
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;

    @Override
    public User selectUserByUsername(String username) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("username", username);
        List<User> users = userDao.selectByMap(map);
        if(users.size() == 0) {
            return null;
        } else if(users.size() > 1) {
            throw new RuntimeException("数据异常");
        } else {
            return (User) userDao.selectByMap(map).get(0);
        }
    }
}
