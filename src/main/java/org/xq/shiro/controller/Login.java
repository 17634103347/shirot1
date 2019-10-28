package org.xq.shiro.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Login {

    /**
     * 登录方法
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("login")
    public String login(String username, String password) {
        //创建Subject 用户主体
        Subject subject  = SecurityUtils.getSubject();
        //创建认证令牌, 传入用户名和密码
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        //执行登录
        try {
            subject.login(token);
        }catch (UnknownAccountException uae) {
            System.out.println("用户名不存在异常!");
            return "login";
        }catch (IncorrectCredentialsException ice) {
            System.out.println("密码错误异常!");
            return "login";
        }catch (AuthenticationException e) {
             System.out.println("用户名或密码错误!");
            e.printStackTrace();
            return "login";
        }
        System.out.println("登录成功");
        return "index";
    }
}
