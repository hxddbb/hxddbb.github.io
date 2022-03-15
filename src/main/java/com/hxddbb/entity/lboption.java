package com.hxddbb.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.math.BigDecimal;
@Data
@TableName("lb_option")
public class lboption {
    @TableId(value = "id",type = IdType.AUTO)//插入数据主键自动递增
    private Integer id;

    private String name;

    private String type;

    @TableField(updateStrategy = FieldStrategy.IGNORED)
    private BigDecimal price;


}