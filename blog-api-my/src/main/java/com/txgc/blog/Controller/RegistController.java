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
@RequestMapping("register")
public class RegistController {
    @Autowired
    private LoginService loginService;
    @PostMapping
    public Result register(@RequestBody LoginParam loginParam){
        //sso单点登录，后期如果把登录注册功能提出去（单独的服务，可以独立提供接口服务）
        return loginService.register(loginParam);
    }

}
