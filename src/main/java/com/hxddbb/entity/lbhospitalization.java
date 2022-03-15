package com.hxddbb.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Data
@TableName("lb_hospitalization")
public class lbhospitalization {
    @TableId(value = "id",type = IdType.AUTO)//预约订单主键自动递增
    private Integer id;

    private String floor;

    private String bed;

    private String door;

    private String medicalName;

    private Integer patientId;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date intime;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date outtime;

    //映射患者名
    @TableField(exist = false)
    private String patientName;

    //映射患者的userid
    @TableField(exist = false)
    private Integer userId;
}