package com.txgc.blog.service;

import com.txgc.blog.dao.pojo.SysUser;
import com.txgc.blog.vo.Result;
import com.txgc.blog.vo.UserVo;

public interface SysUserLoginService {
    //根据token查询用户信息
    Result getUserInfoByToken(String token);
}
