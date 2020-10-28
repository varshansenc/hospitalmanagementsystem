package com.shz.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description 科室
 * @Author shz
 * @Date 2020/10/12 20:01
 * @See com.shz.entity
 */
@Data
@TableName("hms_department")
public class Department implements Serializable {

    @TableId(type = IdType.AUTO)
    private Integer id;
    @JsonProperty("departmentName")
    private String name;
    private String telephone;
    private String area;

}
