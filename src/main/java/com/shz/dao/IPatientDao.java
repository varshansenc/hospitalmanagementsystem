package com.shz.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shz.entity.Patient;
import org.springframework.stereotype.Repository;

/**
 * @Description
 * @Author shz
 * @Date 2020/10/12 22:26
 * @See com.shz.dao
 */
@Repository
public interface IPatientDao extends BaseMapper<Patient> {

}
