package com.atguigu.springboot;

import com.atguigu.springboot.bean.Employee;
import com.atguigu.springboot.mapper.EmployeeMapper;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootTest
class SpringbootCacheApplicationTests {

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    RedisTemplate<Object,Employee> employeeRedisTemplate;
    @Test
    void contextLoads() {
//        Employee employee = employeeMapper.getEmpById(1);
//        System.out.println(employee.toString());


//        stringRedisTemplate.opsForValue().append("msg","钟南山");

        Employee employee = employeeMapper.getEmpById(2);
        //默认如果保存对象，使用jdk序列化机制，序列化后的数据存到redis;可以自己写成json配置
        employeeRedisTemplate.opsForValue().set("emp_02", employee);
    }

}
