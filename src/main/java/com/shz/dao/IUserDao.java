package com.shz.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shz.entity.User;
import org.springframework.stereotype.Repository;

/**
 * @Description
 * @Author shz
 * @Date 2020/10/14 8:49
 * @See com.shz.dao
 */
@Repository
public interface IUserDao extends BaseMapper<User> {


}
