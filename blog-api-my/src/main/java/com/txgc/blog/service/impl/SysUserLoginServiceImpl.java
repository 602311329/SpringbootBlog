package com.txgc.blog.service.impl;


import com.txgc.blog.dao.pojo.SysUser;
import com.txgc.blog.service.LoginService;
import com.txgc.blog.service.SysUserLoginService;
import com.txgc.blog.vo.ErrorCode;
import com.txgc.blog.vo.LoginUserVo;
import com.txgc.blog.vo.Result;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class SysUserLoginServiceImpl implements SysUserLoginService {

    @Autowired
    private LoginService loginService;
    //整合redis
    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    /**
     * @Description: token合法性验证，是否成功，解析是否成功，redis是否存在，如果校验失败，返回false，如果成功返回LoginUserVo
     */
    @Override
    public Result getUserInfoByToken(String token) {
       /**
         * 1.token合法性校验：是否为空   解析是否成功   redis是否存在
         * 2.校验失败：返回错误
         * 3.成功，返回对应结果LoginUserVo
         */

        //校验成功返回用户信息
        SysUser sysUser=loginService.checkToken(token);
        if(sysUser==null){
            return Result.fail(ErrorCode.TOKEN_ERROR.getCode(), ErrorCode.TOKEN_ERROR.getMsg());
        }
        String userJson = redisTemplate.opsForValue().get("TOKEN_" + token);
        if (StringUtils.isBlank(userJson)){
            return Result.fail(ErrorCode.NO_LOGIN.getCode(),ErrorCode.NO_LOGIN.getMsg());
        }
        LoginUserVo loginUserVo=new LoginUserVo();
        loginUserVo.setId(String.valueOf(sysUser.getId()));
        loginUserVo.setNickname(sysUser.getNickname());
        loginUserVo.setAvatar(sysUser.getAvatar());
        loginUserVo.setAccount(sysUser.getAccount());
        return Result.success(loginUserVo);
    }
}
