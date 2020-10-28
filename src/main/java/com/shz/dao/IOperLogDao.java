package com.shz.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shz.entity.OperLog;
import org.springframework.stereotype.Repository;

/**
 * @Description
 * @Author shz
 * @Date 2020/10/19 21:28
 * @See com.shz.dao
 */
@Repository
public interface IOperLogDao extends BaseMapper<OperLog> {

}
