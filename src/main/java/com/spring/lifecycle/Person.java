package com.spring.lifecycle;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * 生命周期测试bean
 *
 * PS: bean生命周期的执行顺序与此对象中方法定义的顺序完全相同。
 * @author sivan
 */
@Data
@Slf4j
public class Person implements InitializingBean, DisposableBean, BeanNameAware, ApplicationContextAware {
    private String name;
    private Integer age;

    public Person() {
        log.info("Person 类通过 '{}()' 实例化", StackTraceUtil.getCurrentMethodName());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * 实现 BeanNameAware
     *
     * @param s
     */
    @Override
    public void setBeanName(String s) {
        log.info("Aware方法：'{}' 的 '{}()' 方法。", "BeanNameAware", StackTraceUtil.getCurrentMethodName());
    }

    /**
     * 实现 ApplicationContextAware
     *
     * @param applicationContext
     * @throws BeansException
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

        ConfigurableApplicationContext configContext = (ConfigurableApplicationContext) applicationContext;
        configContext.getEnvironment().getProperty("spring.name");
        log.info("Aware方法：'{}' 的 '{}()' 方法。", "ApplicationContextAware", StackTraceUtil.getCurrentMethodName());
    }

    /**
     * JSR-205 定义的生命周期注解 @PostConstruct，在实例化之后执行
     */
    @PostConstruct
    public void instantiationAfter() {
        log.info("初始化方法：'{}' 的 '{}()' 方法。", "@PostConstruct", StackTraceUtil.getCurrentMethodName());
    }

    /**
     * 实现 InitializingBean 的初始化方法
     *
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("初始化方法：'{}' 的 '{}()' 方法。", "InitializingBean", StackTraceUtil.getCurrentMethodName());
    }

    /**
     * 由 init-method 指定的自定义方法
     */
    private void customInitMethod() {
        log.info("初始化方法：'{}' 的 '{}()' 方法。", "init-method", StackTraceUtil.getCurrentMethodName());
    }

    /**
     * JSR-205 定义的生命周期注解 @PreDestroy，在销毁之前执行
     */
    @PreDestroy
    private void destroyBefore() {
        log.info("销毁方法：'{}' 的 '{}()' 方法。", "@PreDestroy", StackTraceUtil.getCurrentMethodName());
    }

    /**
     * 由 destroy-method 指定的自定义方法
     */
    private void customDestroyMethod() {
        log.info("销毁方法：'{}' 的 '{}()' 方法。", "destroy-method", StackTraceUtil.getCurrentMethodName());
    }

    /**
     * 实现 DisposableBean
     *
     * @throws Exception
     */
    @Override
    public void destroy() throws Exception {
        log.info("销毁方法：'{}' 的 '{}()' 方法。", "DisposableBean", StackTraceUtil.getCurrentMethodName());
    }

}
