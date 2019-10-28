package org.xq.shiro.dao;

import org.apache.ibatis.annotations.Select;
import org.xq.shiro.pojo.User;

public interface IUserDao {

    @Select("select * from user where name = #{name}")
    public User getUserByname(String name);
}
