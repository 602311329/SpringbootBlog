package com.txgc.blog.dao.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class SysUser {
    //标明是表的id  默认id类型
    //@TableId(type= IdType.ASSIGN_ID) //雪花算法
    //用户多了之后，进行分表操作，id需要分布式id
    //@TableId(type = IdType.AUTO) //自增
    private Long id;

    private String account;

    private Integer admin;

    private String avatar;

    private Long createDate;

    private Integer deleted;

    private String email;

    private Long lastLogin;

    private String mobilePhoneNumber;

    private String nickname;

    private String password;

    private String salt;

    private String status;
}

