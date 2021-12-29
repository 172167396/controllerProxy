package com.dailu.methodenhance.factory;

import com.dailu.methodenhance.proxy.ControllerProxy;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.context.annotation.Primary;

@RequiredArgsConstructor
public class ProxyFactory implements FactoryBean<Object> {

    private final Class<?> target;

    @Override
    public Object getObject() throws Exception {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target);
        enhancer.setCallback(new ControllerProxy(target));
        return enhancer.create();
    }

    @Override
    public Class<?> getObjectType() {
        return target;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }

}
