package com.cn.demo.service;

import com.cn.demo.entity.Department;
import com.cn.demo.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author Wangbo
 * @Date 2019/11/12
 * @Version V1.0
 **/
@Service
public class DepartmentService {

    @Autowired
    DepartmentMapper departmentMapper;

    @Cacheable(cacheNames = "dept")
    public Department getDepById(Integer id) {
        System.out.println("查询部门");
        return departmentMapper.getDepById(id);
    }

    @CacheEvict(cacheNames = "dept",beforeInvocation = true)
    public int delDepById(Integer id){
        System.out.println("删除缓存");
        return departmentMapper.delDepById(id);
    }
}
