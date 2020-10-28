package com.shz.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shz.entity.Department;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description
 * @Author shz
 * @Date 2020/10/12 20:55
 * @See com.shz.dao
 */
@Repository
public interface IDepartmentDao extends BaseMapper<Department> {
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
    List<Department> selectAllDepartments(String departmentName);
}
