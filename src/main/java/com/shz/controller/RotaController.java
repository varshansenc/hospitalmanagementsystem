package com.shz.controller;

import com.github.pagehelper.PageInfo;
import com.shz.entity.ResultVo;
import com.shz.entity.Rota;
import com.shz.service.IRotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Description
 * @Author shz
 * @Date 2020/10/13 9:04
 * @See com.shz.controller
 */
@Controller
@RequestMapping("rota")
public class RotaController {

    @Autowired
    private IRotaService rotaService;

    @RequestMapping("selectAllRota")
    @ResponseBody
    public ResultVo selectAllRota(Integer currentPage, Integer everyPage) {
        List<Rota> rotaList = rotaService.selectAllRota(currentPage, everyPage);
        PageInfo<Rota> pageInfo = new PageInfo<>(rotaList);
        return new ResultVo(pageInfo.getTotal(), pageInfo.getList());
    }
}
