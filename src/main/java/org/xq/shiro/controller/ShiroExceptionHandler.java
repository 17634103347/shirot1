package org.xq.shiro.controller;

import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 统一异常处理类 @ControllerAdvice是全局的控制器类
 */
@ControllerAdvice
public class ShiroExceptionHandler {

    /**
     * 处理授权异常信息
     * @param e
     * @return
     */
    @ExceptionHandler(UnauthorizedException.class)
    public  String handleUnauthorizedException(Exception e) {
        System.out.println("授权失败!" + e.getMessage());
        return "unauthorized"; //跳转到授权失败的页面
    }
}
