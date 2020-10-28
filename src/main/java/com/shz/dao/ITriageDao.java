package com.shz.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shz.entity.Triage;
import com.shz.entity.TriageVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description
 * @Author shz
 * @Date 2020/10/13 20:09
 * @See com.shz.dao
 */
@Repository
public interface ITriageDao extends BaseMapper<Triage> {

    /**
    * @Description 查询所有分诊信息
    * @Author shz
    * @Date 2020/10/13 21:03
    *
    * @Return: java.util.List<com.shz.entity.TriageVo>
    */
    List<TriageVo> selectAllTriage();

    /**
    * @Description 根据科室id查询分诊信息
    * @Author shz
    * @Date 2020/10/13 21:44
    *
    * @Param id
    * @Return: java.util.List<com.shz.entity.Triage>
    **/
    List<Triage> selectTriageByDId(Integer id);

    /**
    * @Description 修改分诊状态
    * @Author shz
    * @Date 2020/10/13 22:29
    *
    * @Param tid
	* @Param status
    * @Return: int
    **/
    int updateTriageStatus(@Param("tid") Integer tid,@Param("status") Integer status);

    /**
    * @Description 根据id查询分诊信息
    * @Author shz
    * @Date 2020/10/14 20:32
    *
    * @Param tid
    * @Return: com.shz.entity.TriageVo
    **/
    TriageVo selectTriageByTid(Integer tid);
}
