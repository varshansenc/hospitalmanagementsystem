package com.shz.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description
 * @Author shz
 * @Date 2020/10/19 20:47
 * @See com.shz.entity
 */
@TableName("hms_operlog")
public class OperLog implements Serializable {
    @TableId(value = "oper_id", type = IdType.AUTO)
    private Integer id;
    @TableField("oper_class_name")
    private String className;
    @TableField("oper_method_name")
    private String methodName;
    @TableField("oper_user_id")
    private Integer userId;
    @TableField("oper_time")
    private Long time;
    @TableField("oper_date")
    private Date date;
    @TableField("oper_module")
    private String module;
    @TableField("oper_type")
    private String type;
    @TableField("oper_description")
    private String description;

    public OperLog() {
    }

    public OperLog(Integer id, String className, String methodName, Integer userId, Long time, Date date,
                   String module, String type, String description) {
        this.id = id;
        this.className = className;
        this.methodName = methodName;
        this.userId = userId;
        this.time = time;
        this.date = date;
        this.module = module;
        this.type = type;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "OperLog{" +
                "id=" + id +
                ", className='" + className + '\'' +
                ", methodName='" + methodName + '\'' +
                ", userId=" + userId +
                ", time=" + time +
                ", date=" + date +
                ", module='" + module + '\'' +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
