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
 * @Description 文件信息表
 * @Author shz
 * @Date 2020/10/12 20:24
 * @See com.shz.entity
 */
@Data
@TableName("hms_files")
public class Files implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer id;
    @TableField("file_name")
    private String fileName;
    @TableField("file_path")
    private String filePath;        // 保存路径
    @TableField("save_name")
    private String saveName;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @TableField("up_time")
    private Date upTime;            // 上传时间
    @TableField("file_size")
    private Integer fileSize;
}
