package com.hxddbb.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;
@Data
@TableName("lb_medicalhistory")
public class lbmedicalhistory {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    private Integer patientId;

    private String name;

    private Date time;

    private Integer hospitalizationId;

    private Integer doctorId;


 //映射
    /*
	患者姓名
	 */
    @TableField(exist = false)
    private String patientName;

    /*
    医生姓名
     */
    @TableField(exist = false)
    private String doctorName;

    @TableField(exist = false)
    private Integer userId;

}