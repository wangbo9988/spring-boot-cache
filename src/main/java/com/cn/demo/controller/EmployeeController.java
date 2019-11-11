package com.cn.demo.controller;

import com.cn.demo.entity.Employees;
import com.cn.demo.mapper.EmployeeMapper;
import com.cn.demo.service.EmployeeService;
import org.apache.ibatis.annotations.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author Wangbo
 * @Date 2019/11/09
 * @Version V1.0
 **/
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/emp/{id}")
    public Employees selectEmpById(@PathVariable("id") Integer id) {
        return employeeMapper.getEmpById(id);
    }

    @GetMapping("/emp1/{id}")
    public Employees insertEmp(@PathVariable("id") Integer id) {
        return employeeService.selectEmpById(id);
    }

    @GetMapping("/emp1ByName/{name}")
    public Employees selectEmpByName(@PathVariable("name") String name) {
        return employeeService.getEmpByName(name);
    }

    @PostMapping("/emp1/upd")
    public Employees updateEmp(Employees employees) {
        return employeeService.updateEmp(employees);
    }

}
