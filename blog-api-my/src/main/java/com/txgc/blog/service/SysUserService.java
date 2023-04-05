package com.txgc.blog.service;

import com.txgc.blog.dao.pojo.SysUser;
import com.txgc.blog.vo.Result;
import com.txgc.blog.vo.UserVo;

public interface SysUserService {
    UserVo findUserVoById(Long id);
    SysUser findUserById(Long id);

    SysUser findUser(String account, String password);

    /**
     * 根据账户查找用户
     * @param account
     * @return
     */
    SysUser findUserByAccount(String account);

    /**
     * 保存用户
     * @param sysUser
     */
    void save(SysUser sysUser);
}
