package com.txgc.blog.Controller;

import com.txgc.blog.dao.pojo.SysUser;
import com.txgc.blog.utils.UserThreadlocal;
import com.txgc.blog.vo.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {
    @RequestMapping
    public Result test(){
        SysUser sysUser= UserThreadlocal.get();
        System.out.println(sysUser);
        return Result.success(null);}
}
