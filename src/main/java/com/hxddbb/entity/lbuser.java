package com.hxddbb.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("lb_user")
public class lbuser {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    private String username;

    private String password;

    private Integer role;

}