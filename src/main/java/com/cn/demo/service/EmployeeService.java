package com.cn.demo.service;

import com.cn.demo.entity.Employees;
import com.cn.demo.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author Wangbo
 * @Date 2019/11/09
 * @Version V1.0
 **/
@Service
public class EmployeeService {

    @Autowired
    public EmployeeMapper employeeMapper;

    /*
     *    @Cacheable——将方法的放回结果进行缓存，这样以后要相同的数据时，我们就可以直接从缓存中获取，不用从数据库获取
     *    CacheManager 管理多个Cache组件，对缓存的真正CRUD操作在Cache组件中，每一个缓存组件有一个唯一的名字
     *    其中几个属性： cacheNames/value：指定缓存的名字
     *                  key：缓存数据使用的key，可以用它来指定。默认使用方法参数的值来作为key，其对应的value为方法的放回值
     *                  keyGenerator：key的生成器，也可以自己指定key的生成器组件id
     *                  （key和keyGenerator二选一指定）
     *                  cacheManager：也可以自己指定缓存管理器
     *                  condition：指定符合条件的情况下才缓存
     *    编写SpEL
     **/
    @Cacheable(cacheNames = "emp", keyGenerator = "MyKeyGenerator", unless = "#result==null")
    public Employees selectEmpById(Integer id) {
        System.out.println("查询");
        return employeeMapper.getEmpById(id);
    }

    // 即调用方法，又更新缓存
    @CachePut(cacheNames = "emp")
    public int updateEmp(Employees employees) {
        System.out.println("员工更新：" + employees);
        return employeeMapper.updateEmp(employees);
    }
}
