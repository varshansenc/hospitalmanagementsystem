package com.shz.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description 分诊记录表
 * @Author shz
 * @Date 2020/10/12 20:04
 * @See com.shz.entity
 */
@Data
@TableName("hms_triage")
public class Triage implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer status;         // 状态  0 等待诊断     1诊断中  2诊断结束
    @TableField("illness_info")
    private String illnessInfo;     // 症状描述
    private String advice;          // 诊断建议
    private String pid;             // 患者id
    private String did;             // 科室id
    private String uid;             // 医生id，指向用户表

    @TableField(exist = false)
    private Patient patient;
}
