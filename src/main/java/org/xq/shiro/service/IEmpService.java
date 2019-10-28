package org.xq.shiro.service;


import org.xq.shiro.pojo.Dept;
import org.xq.shiro.pojo.Emp;

import java.util.List;

public interface IEmpService {

    List<Dept> selectDeptList();

    int insert(Emp pojo);

    int insertList(List<Emp> pojo);

    List<Emp> select(Emp pojo, int pageNum);

    Emp getEmp(Long eid);

    void deleteEmp(Long eid);

    int update(Emp pojo);
}
