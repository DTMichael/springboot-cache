package com.atguigu.springboot.controller;

import com.atguigu.springboot.bean.Employee;
import com.atguigu.springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @GetMapping("/emp/{id}")
    @ResponseBody
    public Employee getEmp(@PathVariable("id") Integer id){
        return employeeService.getEmp(id);
    }

    @GetMapping("/emp/update")
    @ResponseBody
    public Employee updateEmp(Employee employee){
        Employee emp = employeeService.updateEmp(employee);
        System.out.println(emp);
        return emp;
    }

    @GetMapping("/emp/del")
    @ResponseBody
    public String deleteEmp(Employee employee){
        System.out.println("删除id为："+employee.getId()+"的数据");
        return employeeService.deleteEmp(employee.getId());
    }

}
