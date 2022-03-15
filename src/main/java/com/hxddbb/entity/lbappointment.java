package com.hxddbb.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;
@Data
@TableName("lb_appointment")
public class lbappointment {
    @TableId(value = "id",type = IdType.AUTO)//预约订单主键自动递增
    private Integer id;
//患者id
    private Integer patientId;
//医生id
    private Integer doctorId;

    @DateTimeFormat(pattern = "yyyy-MM-dd")//时间模板
    private Date time;
//门诊费
    private BigDecimal expenses;
//就诊状态
    private String status;


    /*映射
    患者名称
     */
    @TableField(exist = false)
    private String patientName;

    /*
    医生名称
     */
    @TableField(exist = false)
    private String doctorName;

    /*
    部门名称
     */
    @TableField(exist = false)
    private String department;

//病人用户的id，因为用户登录的id，根据的是userid不是病人表的id
    @TableField(exist = false)
    private Integer userId;
}