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
 * @Date 2020/10/12 19:51
 * @See com.shz
 */
@Data
@TableName("hms_user")
public class User implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String username;
    private String password;
    private String realname;     // 真实姓名
    private Integer sex;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birth;
    private String mobile;
    private String email;
    private String pic;         // 头像路径
    @TableField("dept_id")
    private String did;        // 表明医生属于哪个科室


}
