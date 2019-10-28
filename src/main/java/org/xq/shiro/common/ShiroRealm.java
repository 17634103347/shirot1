package org.xq.shiro.common;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.xq.shiro.pojo.User;
import org.xq.shiro.service.IUserService;

/**
 * 自定义的Realm 类, 实现登录认证方法
 */
public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    IUserService userService;

    /**
     * 登录认证方法实现
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        //查询用户对象
        User user = userService.getUserByname(token.getUsername());

        if (user == null) {
            throw new UnknownAccountException("用户不存在");
        }
        //将用户名进行盐值加密
        ByteSource credentialsSalt = ByteSource.Util.bytes(user.getName());
        //创建简单的认证信息对象, 在加密的情况下需要 4个参数, 1: 用户身份,可以时用户对象或用户名 , 2: 传入用户的密码, 3: 传入加密的盐值, 4:传入realm名称
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getPassword(), credentialsSalt, getName());

        //创建简单的认证信息对象, 3个参数, 1: 用户身份,可以时用户对象或用户名 , 2: 传入用户的密码, 3:传入realm名称
        //SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getPassword(), getName());
        return info;
    }
    /*
    * 获取授权信息的方法
    * */

    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取当前用户主体
        Subject subject = SecurityUtils.getSubject();
        //可以说用户对象，也可以是用户名称
        User user = (User) subject.getPrincipal();

       //授权信息承载对象
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        if (user.getName().equals("admin")){
            info.addRole("admin");//添加admin角色
            info.addStringPermission("admin");  //添加admin 权限
        }else {
            info.addRole("user"); //添加user角色
            info.addStringPermission("emp");   //添加EMP权限
        }
        System.out.println("角色：" + info.getRoles() + ", 权限"+info.getStringPermissions());
        return info;
    }
}
