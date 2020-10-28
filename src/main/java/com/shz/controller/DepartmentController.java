package com.shz.controller;

import com.github.pagehelper.PageInfo;
import com.shz.anno.Olog;
import com.shz.entity.Department;
import com.shz.entity.ResultVo;
import com.shz.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Description
 * @Author shz
 * @Date 2020/10/12 20:38
 * @See com.shz.controller
 */
@Controller
@RequestMapping("department")
public class DepartmentController {

    @Autowired
    private IDepartmentService departmentService;

    @RequestMapping("selectAllDepartments")
    @ResponseBody
    @Olog(operModule = "科室模块", operType = "分页查询科室", operDesc = "展示所有科室")
    public ResultVo selectAllDepartments(Integer currentPage, Integer everyPage, String departmentName) {
        List<Department> departmentList = departmentService.selectAllDepartments(currentPage, everyPage, departmentName);
        PageInfo<Department> pageInfo = new PageInfo<>(departmentList);
        return new ResultVo(pageInfo.getTotal(), pageInfo.getList());
    }

    @RequestMapping("selectAll")
    @ResponseBody
    @Olog(operModule = "科室模块", operType = "部分也查询所有科室", operDesc = "在下拉列表展示所有科室")
    public ResultVo selectAll() {
        List<Department> departmentList = departmentService.selectAll();
        return new ResultVo((long) departmentList.size(), departmentList);
    }

    @RequestMapping("addDepartment")
    @ResponseBody
    @Olog(operModule = "科室模块", operType = "添加科室", operDesc = "添加科室")
    public ResultVo addDepartment(Department department) {
        int count = departmentService.insertDepartment(department);
        return new ResultVo((long) count, null);
    }

    @RequestMapping("delDepartmentById")
    @ResponseBody
    @Olog(operModule = "科室模块", operType = "删除科室", operDesc = "根据id删除科室")
    public ResultVo delDepartmentById(Integer id) {
        int count = departmentService.delDepartmentById(id);
        return new ResultVo((long) count, null);
    }

    @RequestMapping("deleteSelected")
    @ResponseBody
    @Olog(operModule = "科室模块", operType = "删除选中", operDesc = "删除选中科室")
    public ResultVo deleteSelected(@RequestBody Integer[] ids) {
        int count = departmentService.deleteSelected(ids);
        return new ResultVo((long) count, null);
    }

    @RequestMapping("updateDepartmentById")
    @ResponseBody
    @Olog(operModule = "科室模块", operType = "更新科室", operDesc = "根据id更新科室")
    public ResultVo updateDepartmentById(Department department) {
        int count = departmentService.updateDepartmentById(department);
        return new ResultVo(0, "修改成功", (long) count, null);
    }

}
