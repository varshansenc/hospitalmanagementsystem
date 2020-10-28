package com.shz.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description
 * @Author shz
 * @Date 2020/10/15 12:48
 * @See com.shz.entity
 */
@Data
@TableName("hms_exam")
public class Exam implements Serializable {

    @TableId(type = IdType.AUTO)
    private Integer id;
    @TableField("exam_status")
    private Integer examStatus;             // 审核状态   0 ：未审核    1：审核中   2：审核通过   3：审核未通过
    @TableField("exam_advice")
    private String examAdvice;              // 审核建议
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @TableField("exam_start_date")
    private Date examStartDate;             // 审核开始时间
    @TableField("exam_end_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date examEndDate;               // 审核结束时间
    @TableField("d_id")
    private Integer did;                    // 审核药品的id

    @TableField(exist = false)
    private Drug drug;                      // 审核药品信息

    public Exam() {
    }

    public Exam(Integer id, Integer examStatus, String examAdvice, Date examStartDate, Date examEndDate, Integer did) {
        this.id = id;
        this.examStatus = examStatus;
        this.examAdvice = examAdvice;
        this.examStartDate = examStartDate;
        this.examEndDate = examEndDate;
        this.did = did;
    }
}
