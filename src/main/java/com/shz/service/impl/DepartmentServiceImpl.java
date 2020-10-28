package com.shz.service.impl;

import com.github.pagehelper.PageHelper;
import com.shz.dao.IDepartmentDao;
import com.shz.entity.Department;
import com.shz.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

/**
 * @Description
 * @Author shz
 * @Date 2020/10/12 20:54
 * @See com.shz.service.impl
 */
@Service
@Transactional
public class DepartmentServiceImpl implements IDepartmentService {

    @Autowired
    private IDepartmentDao departmentDao;

    @Override
    @Transactional(readOnly = true)
    public List<Department> selectAllDepartments(Integer currentPage, Integer everyPage, String departmentName) {
        PageHelper.startPage(currentPage, everyPage);
        return departmentDao.selectAllDepartments(departmentName);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Department> selectAll() {
        return departmentDao.selectList(null);
    }

    @Override
    public int insertDepartment(Department department) {
        return departmentDao.insert(department);
    }

    @Override
    public int delDepartmentById(Integer id) {
        return departmentDao.deleteById(id);
    }

    @Override
    public int deleteSelected(Integer[] ids) {
        return departmentDao.deleteBatchIds(Arrays.asList(ids));
    }

    @Override
    public int updateDepartmentById(Department department) {
        return departmentDao.updateById(department);
    }
}
