package com.txgc.blog.service;

import com.txgc.blog.dao.pojo.SysUser;
import com.txgc.blog.vo.Result;
import com.txgc.blog.vo.params.LoginParam;
import org.springframework.transaction.annotation.Transactional;

//事务
@Transactional
public interface LoginService {
    /**
     * 登录功能
     * @param loginParam
     * @return
     */
    Result login(LoginParam loginParam);

    SysUser checkToken(String token);

    /**
     * 退出登录
     * @param token
     * @return
     */
    Result logout(String token);

    /**
     * 注册
     * @param loginParam
     * @return
     */
    Result register(LoginParam loginParam);
}
