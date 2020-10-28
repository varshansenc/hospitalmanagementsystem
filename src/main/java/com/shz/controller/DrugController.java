package com.shz.controller;

import com.github.pagehelper.PageInfo;
import com.shz.entity.Drug;
import com.shz.entity.ResultVo;
import com.shz.service.IDrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Description
 * @Author shz
 * @Date 2020/10/14 21:33
 * @See com.shz.controller
 */
@Controller
@RequestMapping("drug")
public class DrugController {

    @Autowired
    private IDrugService drugService;

    @RequestMapping("selectAllDrug")
    @ResponseBody
    public ResultVo selectAllDrug(Integer currentPage, Integer everyPage, String name) {
        List<Drug> drugList = drugService.selectAllDrug(currentPage, everyPage, name);
        PageInfo<Drug> pageInfo = new PageInfo<>(drugList);
        return new ResultVo(pageInfo.getTotal(), pageInfo.getList());
    }

    @RequestMapping("AddDrug")
    @ResponseBody
    public ResultVo AddDrug(Drug drug) {
        int count = drugService.insertDrug(drug);
        return new ResultVo((long) count, null);
    }

    @RequestMapping("updateDrug")
    @ResponseBody
    public ResultVo updateDrug(Drug drug) {
        int count = drugService.updateDrug(drug);
        return new ResultVo((long) count, null);
    }

    @RequestMapping("updateDrugStatus")
    @ResponseBody
    public ResultVo updateDrugStatus(Drug drug) {
        drug.setSaleStatus(drug.getSaleStatus() == 1 ? 0 : 1);
        int count = drugService.updateDrug(drug);
        return new ResultVo((long) count, null);
    }

    @RequestMapping("delDrugById")
    @ResponseBody
    public ResultVo delDrugById(Integer id) {
        int count = drugService.delDrugById(id);
        return new ResultVo(0, "删除成功",(long) count, null);
    }
}
