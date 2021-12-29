package com.dailu.methodenhance.config;

import com.dailu.methodenhance.annotation.ValidAuth;
import com.dailu.methodenhance.proxy.ControllerProxy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@Slf4j
//@Component
public class CustomBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean.getClass().isAnnotationPresent(Controller.class)
                || bean.getClass().isAnnotationPresent(RestController.class)) {
            boolean needValidate = Arrays.stream(bean.getClass().getDeclaredMethods())
                    .anyMatch(m -> m.isAnnotationPresent(ValidAuth.class));
            if (needValidate) {
                log.info("开始代理：" + bean.getClass() + ".................");
                Enhancer enhancer = new Enhancer();
                enhancer.setSuperclass(bean.getClass());
                enhancer.setCallback(new ControllerProxy(bean));
                return enhancer.create();
            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
