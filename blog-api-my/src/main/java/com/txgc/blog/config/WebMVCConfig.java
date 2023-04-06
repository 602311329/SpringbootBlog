package com.txgc.blog.config;

import com.txgc.blog.handler.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class WebMVCConfig implements WebMvcConfigurer {
    @Autowired
    private LoginInterceptor loginInterceptor;
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        //跨域配置，不可设置为*，不安全, 前后端分离项目，可能域名不一致
        //本地测试 端口不一致 也算跨域  配置域名或当前公网IP地址
        registry.addMapping("/**").allowedOrigins("http://localhost:8080");
        //registry.addMapping("/**").allowedOrigins("http://blog.mszlu.com");
        //registry.addMapping("/**").allowedOrigins("118.31.57.223");  ???
        //registry.addMapping("/**");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //拦截test接口，后续实际遇到拦截的接口时，配置为真正的拦截接口
       registry.addInterceptor(loginInterceptor).
               //博客很少登录，所以只加“/test”
               // addPathPatterns("/**").excludePathPatterns("/login").excludePathPatterns("/register");
               addPathPatterns("/test")
               .addPathPatterns("/comments/create/change")
               .addPathPatterns("/articles/publish");;
    }
}
