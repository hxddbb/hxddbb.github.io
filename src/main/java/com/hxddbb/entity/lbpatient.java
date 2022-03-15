package com.hxddbb.entity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("lb_patient")
public class lbpatient {
    @TableId(value = "id",type = IdType.AUTO)//插入数据主键自动递增
    private Integer id;

    private String name;

    private Integer age;

    private String certId;

    private Integer sex;

    private String address;

    private Integer hospitalizationId;

    private String drugsids;

    private Integer isout;

    private Integer appointmentId;

    private Integer userId;



    //映射的医生名,一定要加这个字段注解，表示在数据库不存在这个列
    @TableField(exist = false)
    private  String doctorName;

    @TableField(exist = false)
    private  Integer doctorId;

    @TableField(exist = false)
    private Integer pageNo=1;

    @TableField(exist = false)
    private Integer pageSize=5;

}