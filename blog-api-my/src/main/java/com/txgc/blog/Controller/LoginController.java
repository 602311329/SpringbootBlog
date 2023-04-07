package com.txgc.blog.Controller;

import com.txgc.blog.service.LoginService;
import com.txgc.blog.vo.Result;
import com.txgc.blog.vo.params.LoginParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("login")
public class LoginController {
//不好，只负责user表的相关操作，业务表另设一个service
    @Autowired
    private LoginService loginService;
    @PostMapping
    public Result login(@RequestBody LoginParam loginParam){
        //登录 验证用户 访问用户表
        Result login = loginService.login(loginParam);
        return login;
    }
}
