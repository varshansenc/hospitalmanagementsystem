package com.shz.service.impl;

import com.github.pagehelper.PageHelper;
import com.shz.dao.ITriageDao;
import com.shz.entity.Triage;
import com.shz.entity.TriageVo;
import com.shz.service.ITriageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description
 * @Author shz
 * @Date 2020/10/13 20:07
 * @See com.shz.service.impl
 */
@Service
@Transactional
public class TriageServiceImpl implements ITriageService {

    @Autowired
    private ITriageDao triageDao;

    @Override
    public int addTriage(Triage triage) {
        return triageDao.insert(triage);
    }

    @Override
    @Transactional(readOnly = true)
    public List<TriageVo> selectAllTriage() {
        return triageDao.selectAllTriage();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Triage> selectTriageByDId(Integer currentPage, Integer everyPage, Integer id) {
        PageHelper.startPage(currentPage, everyPage);
        return triageDao.selectTriageByDId(id);
    }

    @Override
    @Transactional(readOnly = true)
    public TriageVo selectTriageByTId(Integer tid) {
        return triageDao.selectTriageByTid(tid);
    }

    @Override
    public int updateTriageStatus(Integer tid, Integer status) {
        return triageDao.updateTriageStatus(tid, status);
    }

    @Override
    public int updateTriage(Triage triage) {
        triage.setStatus(2);
        return triageDao.updateById(triage);
    }
}
