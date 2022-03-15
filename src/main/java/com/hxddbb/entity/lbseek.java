package com.hxddbb.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.math.BigDecimal;
@Data
@TableName("lb_seek")
public class lbseek {
    @TableId(value = "id" ,type = IdType.AUTO)
    private Integer id;

    private String describes;

    private String illname;

    private String drugs;

    private String options="1";

    private Integer days;

    @TableField(updateStrategy = FieldStrategy.IGNORED)
    private BigDecimal price;

    private Integer patientId;

    private Integer appointmentId;

//映射
    @TableField(exist = false)
private String patientName;
    @TableField(exist = false)
 private String doctorName;

}