package com.shz.controller;

import com.github.pagehelper.PageInfo;
import com.shz.entity.Patient;
import com.shz.entity.ResultVo;
import com.shz.service.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Description
 * @Author shz
 * @Date 2020/10/12 22:21
 * @See com.shz.controller
 */
@Controller
@RequestMapping("patient")
public class PatientController {

    @Autowired
    private IPatientService patientService;

    @RequestMapping("selectAllPatient")
    @ResponseBody
    public ResultVo selectAllPatient(Integer currentPage, Integer everyPage) {
        List<Patient> patientList = patientService.selectAllPatient(currentPage, everyPage);
        PageInfo<Patient> pageInfo = new PageInfo<>(patientList);
        return new ResultVo(pageInfo.getTotal(), pageInfo.getList());
    }

    @RequestMapping("addPatient")
    @ResponseBody
    public ResultVo addPatient(Patient patient) {
        int count = patientService.addPatient(patient);
        return new ResultVo((long) count, null);
    }

    @RequestMapping("updatePatient")
    @ResponseBody
    public ResultVo updatePatient(Patient patient) {
        int count = patientService.updatePatient(patient);
        return new ResultVo((long) count, null);
    }

    @RequestMapping("delPatient")
    @ResponseBody
    public ResultVo delPatient(Integer id) {
        int count = patientService.delPatient(id);
        return new ResultVo((long) count, null);
    }



}
