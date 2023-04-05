package com.txgc.blog.admain.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Admin {
    //变为自增的，不用分布式id
    @TableId(type = IdType.AUTO)
    private Long id;

    private String username;

    private String password;
}
