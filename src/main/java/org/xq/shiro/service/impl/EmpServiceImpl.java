package org.xq.shiro.service.impl;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.xq.shiro.dao.EmpDao;
import org.xq.shiro.pojo.Dept;
import org.xq.shiro.pojo.Emp;
import org.xq.shiro.service.IEmpService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EmpServiceImpl implements IEmpService {

    @Resource
    private EmpDao empDao;

    //缓存列表, 缓存名称使用初始化中已创建的 emp-list2, 它的失效时间时2分钟
    public List<Dept> selectDeptList() {
        return empDao.selectDeptList();
    }

    public int insert(Emp pojo){
        return empDao.insert(pojo);
    }

    public int insertList(List< Emp> pojos){
        return empDao.insertList(pojos);
    }

    public List<Emp> select(Emp pojo, int pageNum){
        return empDao.select(pojo);
    }

    public Emp getEmp(Long eid) {
        return empDao.getEmp(eid);
    }

    public void deleteEmp(Long eid) {
        empDao.deleteEmp(eid);
    }

    public int update(Emp pojo){
        return empDao.update(pojo);
    }


}
