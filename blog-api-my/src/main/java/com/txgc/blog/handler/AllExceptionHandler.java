package com.txgc.blog.handler;

import com.txgc.blog.vo.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

//AOP的一个实现，对加了@Controller的方法进行拦截处理
@ControllerAdvice
public class AllExceptionHandler {
    //进行异常处理，处理Exception.class异常
    @ExceptionHandler(Exception.class)
    //返回json数据，不加的话，是返回这个页面
    @ResponseBody
    public Result doException(Exception ex){
        ex.printStackTrace();
        return Result.fail(-999,"系统异常");
    }
}
