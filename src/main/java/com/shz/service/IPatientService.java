package com.shz.service;

import com.shz.entity.Patient;

import java.util.List;

/**
 * @Description
 * @Author shz
 * @Date 2020/10/12 22:24
 * @See com.shz.service
 */
public interface IPatientService {

    /**
    * @Description 查询所有患者
    * @Author shz
    * @Date 2020/10/12 22:25
    *
    * @Param currentPage
	* @Param everyPage
    * @Return: java.util.List<com.shz.entity.Patient>
    **/
    List<Patient> selectAllPatient(Integer currentPage, Integer everyPage);

    /**
    * @Description 添加患者
    * @Author shz
    * @Date 2020/10/13 8:13
    *
    * @Param patient
    * @Return: int
    **/
    int addPatient(Patient patient);

    /**
    * @Description 修改患者
    * @Author shz
    * @Date 2020/10/13 8:28
    *
    * @Param patient
    * @Return: int
    **/
    int updatePatient(Patient patient);

    /**
    * @Description 删除患者
    * @Author shz
    * @Date 2020/10/13 8:54
    *
    * @Param id
    * @Return: int
    **/
    int delPatient(Integer id);

    /**
    * @Description 根据id查询患者
    * @Author shz
    * @Date 2020/10/16 10:45
    *
    * @Param pid
    * @Return: com.shz.entity.Patient
    **/
    Patient selectPatientById(String pid);
}
