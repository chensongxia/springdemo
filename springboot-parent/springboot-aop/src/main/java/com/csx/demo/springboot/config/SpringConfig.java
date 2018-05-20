package com.csx.demo.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
//自动选择合适的AOP代理
//传统xml这样配置：<aop:aspectj-autoproxy/>
@EnableAspectJAutoProxy
public class SpringConfig {

}
