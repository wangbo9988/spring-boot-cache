package com.cn.demo.config;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @Description 自定义KeyGenerator
 * @Author Wangbo
 * @Date 2019/11/10
 * @Version V1.0
 **/
@Configuration
public class MyCacheConfig {

    @Bean("MyKeyGenerator")
    public KeyGenerator keyGenerator() {
        return new KeyGenerator() {

            @Override
            public Object generate(Object o, Method method, Object... objects) {
                return method.getName() + "[" + Arrays.asList(objects).toString() + "]";
            }
        };
    }


}
