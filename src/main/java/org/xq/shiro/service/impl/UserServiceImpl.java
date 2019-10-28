package org.xq.shiro.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xq.shiro.dao.IUserDao;
import org.xq.shiro.pojo.User;
import org.xq.shiro.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    IUserDao userDao;
    public User getUserByname(String name) {
        return userDao.getUserByname(name);
    }
}
