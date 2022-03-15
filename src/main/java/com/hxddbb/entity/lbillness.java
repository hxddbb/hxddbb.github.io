package com.hxddbb.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("lb_illness")
public class lbillness {
    @TableId(value = "id",type = IdType.AUTO)//插入数据主键自动递增
    private Integer id;

    private String name;

    private String text;

}