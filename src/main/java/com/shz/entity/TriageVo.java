package com.shz.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description 分诊部门表
 * @Author shz
 * @Date 2020/10/13 20:54
 * @See com.shz.entity
 */
@Data
public class TriageVo implements Serializable {

    private Integer id;                     // 科室id
    private String departmentName;          // 科室名
    private String area;                    // 科室位置
    private Integer patientCount;           // 该科室挂号人数

    private Integer tid;                    // 分诊id
    private Integer pid;                    // 患者id
    private String pname;                   // 患者姓名
}
