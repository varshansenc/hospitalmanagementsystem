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
 * @Description 药品表
 * @Author shz
 * @Date 2020/10/12 20:26
 * @See com.shz.entity
 */
@Data
@TableName("hms_drug")
public class Drug implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    private String spec;        // 规格
    private String unit;        // 单位
    @TableField("product_company")
    private String productCompany;      // 生产企业
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @TableField("product_date")
    private Date productDate;            // 生产日期
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @TableField("ok_date")
    private Date okDate;                 // 保质期
    @TableField("import_price")
    private Double importPrice;          // 进价
    private Double price;                // 零售价
    @TableField("sale_status")
    private Integer saleStatus;          // 销售状态  （0：正常销售    1：停售）
    @TableField("is_import")
    private Integer isImport;            // 是否是进口(0:是   1：非进口药)
    private String description;          // 产品说明
}
