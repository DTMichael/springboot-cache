package com.atguigu.springboot.service;

import com.atguigu.springboot.bean.Employee;
import com.atguigu.springboot.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    /*
    将方法的运行结果放到缓存中，以后再要相同的数据直接从缓存中获取，不用调用方法了
        @Cacheable参数：
            1、cacheManager/value【指定缓存结果名；将方法返回结果放到哪个缓存中。是数组的方式，可以指定多个缓存；】
            2、key【缓存数据时用的键，默认使用参数的值(id)，可以参考SPEL表达式进行自定义key值】
            2、keyGenerator【key生成器，可以用它来指定keyd的生成器的组件id；key/keyGenerator二选一使用。使用自定义keygenerator需要配置】
            3、cacheManager【指定缓存管理器；或者cacheResolver指定获取解析器】
            4、condition【指定条件成立才缓存;eg:condition="#id>0",eg:,condition = "#a0>1 and #root.methodName eq 'aaa'"】
            5、unless【指定条件成立不缓存;eg:unless="#result==null"(当结果为空，不缓存)】
            6、sync【是否使用异步模式,默认是【false】方法执行完，以同步的方式将方法返回的结果存在缓存中】
        @Cacheable原理
        1、自动配置类：CacheAutoConfiguration



     */
    @Autowired
    EmployeeMapper employeeMapper;

    @Cacheable(value = {"emp"}/*,unless = "#result==null",keyGenerator = "mykeygenerator"*/)
    public Employee getEmp(Integer id){
        System.out.println("查询"+id+"号员工信息");
        return employeeMapper.getEmpById(id);
    }

    /*
    @CachePut，既调用方法，且也更新缓存
            修改了数据库中信息，同时也修改了缓存
     */
    @CachePut(value = "emp",key = "#employee.id")
    public Employee updateEmp(Employee employee){
        employeeMapper.UpdateEmp(employee);
        return employee;
    }

    /*
    @CacheEvict
        key:指定要删除的数据
        allEntries:是否删除value下的所有的缓存
        beforeInvocation=false;缓存的清除是否在方法之前执行
        默认是在方法之后清除
     */
    @CacheEvict(value = "emp",key = "#id",allEntries = true)
    public String deleteEmp(Integer id){
        employeeMapper.deleteEmp(id);
        return "success";
    }

    /*
    @Caching
        可以一次指定多个缓存注解
            eg:
            @Caching(
            cacheable = {
                    @Cacheable(value = "emp",key = "#lastName")
                        },
            put = {
                    @CachePut(value = "emp",key = "#result.id",
                    @CachePut(value="emp",key = "#result.email"))
                    }
                    )
     @Cach
     */

    /*
    @CacheConfig
    可以指定公共注解配置：cacheNames，keyGenerator，cacheManager，cacheResolver
     */



}
