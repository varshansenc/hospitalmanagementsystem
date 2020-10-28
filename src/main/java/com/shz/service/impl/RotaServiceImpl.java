package com.shz.service.impl;

import com.github.pagehelper.PageHelper;
import com.shz.dao.IRotaDao;
import com.shz.entity.Rota;
import com.shz.service.IRotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description
 * @Author shz
 * @Date 2020/10/13 9:07
 * @See com.shz.service.impl
 */
@Service
@Transactional
public class RotaServiceImpl implements IRotaService {

    @Autowired
    private IRotaDao rotaDao;

    @Override
    @Transactional
    public List<Rota> selectAllRota(Integer currentPage, Integer everyPage) {
        PageHelper.startPage(currentPage, everyPage);
        return rotaDao.selectAllRota();
    }
}
