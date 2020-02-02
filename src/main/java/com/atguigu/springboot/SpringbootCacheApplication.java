package com.atguigu.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/*
搭建基本环境
1、创建department、employee两张表
2、创建javabean封装数据
3、整合mybatis操作数据库
    1、配置数据源
    2、注解版mybatis
        1、指定扫描的mapper接口包
快速体验缓存
    步骤
        1、开启基于注解的缓存@EnableCaching
        2、标注缓存注解即可

整合redis作为缓存
    1、安装redis
    2、引入redis的starter
    3、配置redis
    4、使用Redis自动配置类提供的两个实现类RedisTemplate和StringRedisTemplate，默认使用jdkSerializable如果需要自定义序列化器，则需要重新写一个配置。
    5、配置RedisCacheManager，实现Redis缓存的序列化器为json。【MyRedisConfig】

 */
@MapperScan("com.atguigu .springboot.mapper")
@SpringBootApplication
@EnableCaching
public class SpringbootCacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootCacheApplication.class, args);
    }

}
