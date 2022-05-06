package com.dailu.methodenhance.proxy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

@Slf4j
public class UserServiceProxy implements MethodInterceptor {

    private Object target;

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("开始代理" + target.getClass());
        Object result = method.invoke(target, objects);
        log.debug("代理完成，返回" + result.toString());
        return result;
    }

    public Object getProxy(Object target) {
        Enhancer enhancer = new Enhancer();
        this.target = target;
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }
}
