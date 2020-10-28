package com.shz.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shz.entity.Rota;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description
 * @Author shz
 * @Date 2020/10/13 9:09
 * @See com.shz.dao
 */
@Repository
public interface IRotaDao extends BaseMapper<Rota> {


    /**
    * @Description 查询所有值班信息
    * @Author shz
    * @Date 2020/10/13 9:13
    * 
    
    * @Return: java.util.List<com.shz.entity.Rota>
    **/
    List<Rota> selectAllRota();
}
