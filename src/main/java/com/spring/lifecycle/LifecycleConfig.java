package com.spring.lifecycle;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 生命周期测试配置类
 */
@Configuration
public class LifecycleConfig {

    /**
     * 配置自定义 BeanPostProcessor
     */
    @Bean
    public BeanPostProcessor beanPostProcessor(){
        return new TracingBeanPostProcessor();
    }

    @Bean(initMethod = "customInitMethod", destroyMethod = "customDestroyMethod")
    public Person person(){
        return new Person();
    }

}
