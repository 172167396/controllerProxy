package com.dailu.methodenhance.interceptor;

import com.dailu.methodenhance.annotation.ValidAuth;
import org.aopalliance.aop.Advice;
import org.springframework.aop.Pointcut;
import org.springframework.aop.support.AbstractPointcutAdvisor;
import org.springframework.aop.support.ComposablePointcut;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

public class ControllerAdvisor extends AbstractPointcutAdvisor implements BeanFactoryAware {

    private final Advice advice;
    private final Pointcut pointcut;

    public ControllerAdvisor(Advice advice){
        this.advice = advice;
        this.pointcut = buildPointcut();
    }

    @Override
    public Pointcut getPointcut() {
        return pointcut;
    }

    @Override
    public Advice getAdvice() {
        return advice;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
    }

    private Pointcut buildPointcut() {
        Pointcut cpc = new AnnotationMatchingPointcut(ValidAuth.class, true);
//        AnnotationMatchingPointcut.forClassAnnotation()
        Pointcut mpc = AnnotationMatchingPointcut.forMethodAnnotation(ValidAuth.class);
        return new ComposablePointcut(cpc).union(mpc);
    }
}
