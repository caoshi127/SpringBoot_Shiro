package com.zzuli.handler;

import com.zzuli.utils.ResultObj;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常监控 监控 UnauthorizedException 异常 未授权异常
 * @author CaoShi
 * @time 2019/11/20 17:08
 */
@RestControllerAdvice
public class GlobalExceptionHandlerAdvice {

    /**
     * 未授权
     * 只要当前项目的代码抛出 UnauthorizedException 异常就回调该方法
     * @return UNAUTHORIZED 未授权
     */
    @ExceptionHandler(value = UnauthorizedException.class)
    public ResultObj unauthorized() {
        return ResultObj.UNAUTHORIZED;
    }

}
