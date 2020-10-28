package com.shz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.shz.dao.IDrugDao;
import com.shz.entity.Drug;
import com.shz.service.IDrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description
 * @Author shz
 * @Date 2020/10/14 21:37
 * @See com.shz.service.impl
 */
@Service
@Transactional
public class DrugServiceImpl implements IDrugService {

    @Autowired
    private IDrugDao drugDao;

    @Override
    @Transactional(readOnly = true)
    public List<Drug> selectAllDrug(Integer currentPage, Integer everyPage, String name) {
        name = name == null ? "" : name;
        PageHelper.startPage(currentPage, everyPage);
        return drugDao.selectList(new QueryWrapper<Drug>().like("name", name));
    }

    @Override
    public int insertDrug(Drug drug) {
        return drugDao.insert(drug);
    }

    @Override
    public int updateDrug(Drug drug) {
        return drugDao.updateById(drug);
    }

    @Override
    public int delDrugById(Integer id) {
        return drugDao.deleteById(id);
    }
}
