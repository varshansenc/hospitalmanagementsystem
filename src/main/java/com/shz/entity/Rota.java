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
 * @Description 值班表
 * @Author shz
 * @Date 2020/10/12 20:08
 * @See com.shz.entity
 */
@Data
@TableName("hms_rota")
public class Rota implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer id;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @TableField("rota_date")
    private Date rotaDate;                  // 值班日期
    private String did;                     // 科室外键
    private String uid;                     // 医生用户的id

    @TableField(exist = false)
    private Department department;          // 科室
    @TableField(exist = false)
    private User user;                      // 医生
}
