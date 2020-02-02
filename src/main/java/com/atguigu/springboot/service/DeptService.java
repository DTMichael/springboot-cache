package com.atguigu.springboot.service;

import com.atguigu.springboot.bean.Department;
import com.atguigu.springboot.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@Cacheable(cacheNames = "dept")
public class DeptService {
    @Autowired
    DepartmentMapper departmentMapper;
    public Department GetDept(Integer id){
        System.out.println("查询id为"+id+"的部门信息");
        Department dept=departmentMapper.GetDeptById(id);
        System.out.println(dept.toString());
        return dept;
    }
}
