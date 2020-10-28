package com.shz.service.impl;

import com.github.pagehelper.PageHelper;
import com.shz.dao.IPatientDao;
import com.shz.entity.Patient;
import com.shz.service.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description
 * @Author shz
 * @Date 2020/10/12 22:25
 * @See com.shz.service.impl
 */
@Service
@Transactional
public class PatientServiceImpl implements IPatientService {

    @Autowired
    private IPatientDao patientDao;

    @Override
    @Transactional(readOnly = true)
    public List<Patient> selectAllPatient(Integer currentPage, Integer everyPage) {
        PageHelper.startPage(currentPage, everyPage);
        return patientDao.selectList(null);
    }

    @Override
    public int addPatient(Patient patient) {
        return patientDao.insert(patient);
    }

    @Override
    public int updatePatient(Patient patient) {
        return patientDao.updateById(patient);
    }

    @Override
    public int delPatient(Integer id) {
        return patientDao.deleteById(id);
    }

    @Override
    public Patient selectPatientById(String pid) {
        return patientDao.selectById(pid);
    }
}
