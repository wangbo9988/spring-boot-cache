package com.cn.demo;

import com.cn.demo.entity.Employees;
import com.cn.demo.mapper.EmployeeMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootTest
class SpringBootCacheApplicationTests {

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    StringRedisTemplate stringRedisTemplate;    // 操作的 k-v 都是字符串

    @Autowired
    RedisTemplate<Object, Object> redisTemplate;

    @Test
    public void test01() {
        // 向Redis中保存数据
        stringRedisTemplate.opsForValue().append("msg", "Hello World");
        String msg = stringRedisTemplate.opsForValue().get("msg");
        System.out.println(msg);
    }

    @Test
    public void test02() {
        Employees employees = employeeMapper.getEmpById(1);
        System.out.println(employees);
        redisTemplate.opsForValue().set("emp", employees);
    }


}
