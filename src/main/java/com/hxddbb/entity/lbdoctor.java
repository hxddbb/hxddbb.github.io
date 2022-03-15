package com.hxddbb.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("lb_doctor")
public class lbdoctor {
    @TableId(value = "id",type = IdType.AUTO)//插入数据主键自动递增
    private Integer id;

    private String name;

    private Integer age;

    private String certId;

    private Integer sex;

    private String department;

    private String address;

    private Integer userId;

    private Integer expert;

    private String text;

}