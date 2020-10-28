package com.shz.service;

import com.shz.entity.Department;

import java.util.List;

/**
 * @Description
 * @Author shz
 * @Date 2020/10/12 20:45
 * @See com.shz.service
 */
public interface IDepartmentService {

    /**
    * @Description 查询科室
    * @Author shz
    * @Date 2020/10/12 20:53
    *
    * @Param currentPage    页码
	* @Param everyPage      每页条数
	* @Param departmentName 部门名称
    * @Return: java.util.List<com.shz.entity.Department>
    **/
    List<Department> selectAllDepartments(Integer currentPage, Integer everyPage, String departmentName);

    /**
    * @Description 添加科室
    * @Author shz
    * @Date 2020/10/12 21:24
    *
    * @Param department
    * @Return: int
    **/
    int insertDepartment(Department department);

    /**
    * @Description 删除科室
    * @Author shz
    * @Date 2020/10/12 21:38
    *
    * @Param id
    * @Return: int
    **/
    int delDepartmentById(Integer id);

    /**
    * @Description 删除选中行
    * @Author shz
    * @Date 2020/10/12 21:42
    *
    * @Param ids
    * @Return: int
    **/
    int deleteSelected(Integer[] ids);

    /**
    * @Description 修改科室
    * @Author shz
    * @Date 2020/10/12 22:08
    *
    * @Param department
    * @Return: int
    **/
    int updateDepartmentById(Department department);

    /**
    * @Description 查询所有科室
    * @Author shz
    * @Date 2020/10/13 19:52
    *
    * @Return: java.util.List<com.shz.entity.Department>
    **/
    List<Department> selectAll();
}
