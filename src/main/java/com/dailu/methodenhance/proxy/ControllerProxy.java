package com.dailu.methodenhance.proxy;

import com.dailu.methodenhance.annotation.ValidAuth;
import com.dailu.methodenhance.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

@Slf4j
@RequiredArgsConstructor
public class ControllerProxy implements MethodInterceptor {

    private final Object originTarget;

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        ValidAuth annotation = method.getAnnotation(ValidAuth.class);
        if (annotation == null) {
            return method.invoke(originTarget, objects);
        }
        int role = annotation.hasRole();
        double random = Math.random();
        log.info("random is :"+random);
        int myRole = (int)(Math.floor(random*10) +1);
        if(myRole+1 > role){
            log.info("执行代理，修改userName...........");
            Object result = method.invoke(originTarget, objects);
            if(result instanceof UserEntity){
                ((UserEntity) result).setName("海绵宝宝");
            }
            return result;
        }
        throw new RuntimeException("权限不足，您的权限是："+myRole+",需要权限："+role);
    }

}
