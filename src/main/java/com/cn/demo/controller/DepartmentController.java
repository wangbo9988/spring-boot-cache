package com.cn.demo.controller;

import com.cn.demo.entity.Department;
import com.cn.demo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author Wangbo
 * @Date 2019/11/12
 * @Version V1.0
 **/
@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping(value = "/dep/{id}")
    public Department getDepById(@PathVariable("id") Integer id) {
        return departmentService.getDepById(id);
    }

    @GetMapping(value = "/del/dep/{id}")
    public int delDepById(@PathVariable("id") Integer id) {
        return departmentService.delDepById(id);
    }

}
