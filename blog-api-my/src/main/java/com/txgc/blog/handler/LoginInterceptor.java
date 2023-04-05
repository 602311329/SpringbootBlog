package com.txgc.blog.handler;

import com.alibaba.fastjson.JSON;
import com.txgc.blog.dao.pojo.SysUser;
import com.txgc.blog.service.LoginService;
import com.txgc.blog.utils.UserThreadlocal;
import com.txgc.blog.vo.ErrorCode;
import com.txgc.blog.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//spring能识别到
@Component
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {
    @Autowired
    private LoginService loginService;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //再执行controller方法（handler）之前进行执行
        /**
         * 1.需要判断请求的接口路径是否为 HandlerMethod（controller方法，访问资源不用拦截）
         * 2.判断token是否为空  为空未登录
         * 3.不为空，登录验证loginservice checktoken
         * 4.认证成功，放行
         */
        if(!(handler instanceof HandlerMethod)){
            //handler可能是 RequestResourceHandler springboot 程序访问静态资源默认去classpath下的static目录查询
            return true;
        }
        String token = request.getHeader("Authorization");
        log.info("=================request start===========================");
        String requestURI = request.getRequestURI();
        log.info("request uri:{}",requestURI);
        log.info("request method:{}",request.getMethod());
        log.info("token:{}", token);
        log.info("=================request end===========================");

        if (StringUtils.isBlank(token)) {
            Result result = Result.fail(ErrorCode.NO_LOGIN.getCode(), "未登录");
            //浏览器识别返回的数据是json
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().print(JSON.toJSONString(result));
            return false;
        }
        SysUser sysUser=loginService.checkToken(token);
        if (sysUser==null) {
            Result result = Result.fail(ErrorCode.NO_LOGIN.getCode(), "未登录");
            //浏览器识别返回的数据是json
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().print(JSON.toJSONString(result));
            return false;
        }
        //登陆验证成功  放行
        //希望在controller中直接获取用户的信息，怎么获取
        UserThreadlocal.put(sysUser);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //如果不删除Threadlocal中用完的信息  有内存泄露的风险
        //不删的话 这个controller结束以后，user信息还存在thread里面，其他人可以调用
        //key是弱引用 value是强引用 弱引用被回收 强引用的对象就无法被回收
        UserThreadlocal.remove();
    }
}
