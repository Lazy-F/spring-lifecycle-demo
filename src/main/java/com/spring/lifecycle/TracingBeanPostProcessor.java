package com.spring.lifecycle;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * Bean后置处理器
 *
 * 官方文档：
 * https://docs.spring.io/spring/docs/5.1.8.RELEASE/spring-framework-reference/core.html#beans-factory-extension
 *
 * @author sivan
 */
@Slf4j
public class TracingBeanPostProcessor implements BeanPostProcessor {

    /**
     * 初始化之前执行
     *
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        log.info("初始化之前执行。Class: {}. Bean Name: {}", bean.getClass().getSimpleName(), beanName);

        // do something
        return bean;
    }

    /**
     * 初始化之后执行
     *
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        log.info("初始化之后执行。Class: {}. Bean Name: {}", bean.getClass().getSimpleName(), beanName);

        // do something
        return bean;
    }
}
