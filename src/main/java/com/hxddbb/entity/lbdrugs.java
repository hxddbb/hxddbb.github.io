package com.hxddbb.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
@Data
@TableName("lb_drugs")
public class lbdrugs {
    @TableId(value = "id",type = IdType.AUTO)//插入数据主键自动递增
    private Integer id;

    private String name;

    private Integer type;

    private BigDecimal price;

    private Integer number;

    private String text;


}