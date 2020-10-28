package com.shz.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description 日志
 * @Author shz
 * @Date 2020/10/12 20:20
 * @See com.shz.entity
 */
//@Data
@TableName("hms_log")
public class Log implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer type;           // 日志类型  1.登录日志， 2.诊断日志
    private String operator;        // 日志操作人的真实姓名
    private String content;         // 操作内容
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField("log_date")
    private Date logDate;

    public Log() {
    }

    public Log(Integer id, Integer type, String operator, String content, Date logDate) {
        this.id = id;
        this.type = type;
        this.operator = operator;
        this.content = content;
        this.logDate = logDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getLogDate() {
        return logDate;
    }

    public void setLogDate(Date logDate) {
        this.logDate = logDate;
    }

    @Override
    public String toString() {
        return "Log{" +
                "id=" + id +
                ", type=" + type +
                ", operator='" + operator + '\'' +
                ", content='" + content + '\'' +
                ", logDate=" + logDate +
                '}';
    }
}
