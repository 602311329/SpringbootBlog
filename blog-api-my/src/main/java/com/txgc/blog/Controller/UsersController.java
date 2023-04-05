package com.txgc.blog.Controller;

import com.txgc.blog.service.SysUserLoginService;
import com.txgc.blog.service.SysUserService;
import com.txgc.blog.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UsersController {
    @Autowired
    private SysUserLoginService sysUserLoginService;
    @GetMapping("currentUser")
    public Result currentUser(@RequestHeader("Authorization") String token){
        return sysUserLoginService.getUserInfoByToken(token);
    }
}
