package org.xq.shiro.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.xq.shiro.common.JsonResponse;
import org.xq.shiro.pojo.Dept;
import org.xq.shiro.pojo.Emp;
import org.xq.shiro.service.IEmpService;


import java.util.List;
import java.util.Map;

@Controller
public class EmpController {

    @Autowired
    IEmpService empService;
    @GetMapping("emp/query")
    @ResponseBody
    public PageInfo<Emp> getEmpList(Emp emp, @RequestParam(defaultValue = "1", required = true) Integer pageNum) {
        //开发分页拦截
        PageHelper.startPage(pageNum, 10);
        List<Emp> empList = empService.select(new Emp(), pageNum);
        //创建分页对象
        PageInfo<Emp> pageInfo = new PageInfo<Emp>(empList);
        return pageInfo;
    }

    /**
     * 跳转到admin列表
     * @param
     * @return
     */
    @RequiresPermissions({"admin"})
    @GetMapping("goAdmin")
    public String toAdmin() {
        return "admin";
    }

    /**
     * 添加方法
     * @param emp
     * @return
     */
    @PostMapping("emp/add")
    public Map<String,Object> save(Emp emp) {
        empService.insert(emp);
        return JsonResponse.success(200, "添加成功!");
    }

    @GetMapping("emp/deptlist")
    public List<Dept> getDeptList() {
        return empService.selectDeptList();
    }
}
