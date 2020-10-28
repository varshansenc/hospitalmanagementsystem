package com.shz.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shz.entity.Log;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description
 * @Author shz
 * @Date 2020/10/16 9:47
 * @See com.shz.dao
 */
@Repository
public interface ILogDao extends BaseMapper<Log> {

    /**
    * @Description 查询所有日志
    * @Author shz
    * @Date 2020/10/18 10:04
    * 
    * @Param name
	* @Param type
    * @Return java.util.List<com.shz.entity.Log>
    **/
    List<Log> selectAllLog(@Param("name") String name, @Param("type") Integer type);
}
