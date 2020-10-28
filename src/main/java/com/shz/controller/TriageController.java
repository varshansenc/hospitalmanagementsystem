package com.shz.controller;

import com.github.pagehelper.PageInfo;
import com.shz.entity.*;
import com.shz.service.ILogService;
import com.shz.service.IPatientService;
import com.shz.service.ITriageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * @Description
 * @Author shz
 * @Date 2020/10/13 20:03
 * @See com.shz.controller
 */
@Controller
@RequestMapping("triage")
public class TriageController {

    @Autowired
    private ITriageService triageService;

    @Autowired
    private IPatientService patientService;

    @Autowired
    private ILogService logService;



    @RequestMapping("addTriage")
    @ResponseBody
    public ResultVo addTriage(Triage triage) {
        triage.setStatus(0);
        int count = triageService.addTriage(triage);
        return new ResultVo(0, "挂号成功", (long) count, null);
    }

    @RequestMapping("selectAllTriage")
    @ResponseBody
    public ResultVo selectAllTriage() {
        List<TriageVo> triageVoList = triageService.selectAllTriage();
        return new ResultVo((long) triageVoList.size(), triageVoList);
    }

    @RequestMapping("selectTriageByDId")
    @ResponseBody
    public ResultVo selectTriageByDId(Integer currentPage, Integer everyPage, Integer id) {
        List<Triage> triageList = triageService.selectTriageByDId(currentPage, everyPage, id);
        PageInfo<Triage> pageInfo = new PageInfo<>(triageList);
        return new ResultVo(pageInfo.getTotal(), pageInfo.getList());
    }

    @RequestMapping("selectTriageByTid")
    @ResponseBody
    public TriageVo selectTriageByTid(Integer tid) {
        return triageService.selectTriageByTId(tid);
    }

    @RequestMapping("updateTriageStatus")
    @ResponseBody
    public ResultVo updateTriageStatus(Integer tid, Integer status) {
        int count = triageService.updateTriageStatus(tid, status);
        return new ResultVo(0, "叫号成功", (long) count, null);
    }

    @RequestMapping("updateTriage")
    @ResponseBody
    public ResultVo updateTriage(HttpSession session, Triage triage) {
        User user = (User) session.getAttribute("user");
        String realname = user.getRealname();

        Patient patient = patientService.selectPatientById(triage.getPid());

        logService.insertLog(new Log(null, 1, realname, "诊断了病人" + patient.getName(), new Date()));

        triage.setStatus(2);
        int count = triageService.updateTriage(triage);
        return new ResultVo(0, "诊断完成", (long) count, null);
    }
}
