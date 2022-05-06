package com.dailu.methodenhance.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.stereotype.Component;

@Component
public class BeanFactoryHelper implements BeanNameAware, BeanFactoryAware {

    private static BeanFactory beanFactory;

    private String id;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        BeanFactoryHelper.beanFactory = beanFactory;
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("bean name is " + name);
        this.id = name;
    }

    public static void registryBean(String id, Object bean) {
        ((DefaultListableBeanFactory) beanFactory).destroyBean(id);
        ((DefaultListableBeanFactory) beanFactory).registerSingleton(id,bean);
    }

}
