package org.xq.shiro.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.xq.shiro.pojo.Dept;
import org.xq.shiro.pojo.Emp;

//@mapper注解用于spirng扫描器扫描到容器中生产动态代理类
@Mapper
public interface EmpDao {

    @Select("select * from dept")
    List<Dept> selectDeptList();

    int insert(@Param("pojo") Emp pojo);

    int insertList(@Param("pojos") List<Emp> pojo);

    List<Emp> select(@Param("pojo") Emp pojo);

    int update(@Param("pojo") Emp pojo);

    @Select("select * from emp where eid = #{eid}")
    Emp getEmp(Long eid);

    @Delete("delete from emp where eid=#{eid}")
    void deleteEmp(Long eid);
}
