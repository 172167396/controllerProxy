package com.dailu.methodenhance.interceptor;

import com.dailu.methodenhance.annotation.ValidAuth;
import com.dailu.methodenhance.entity.UserEntity;
import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

@Slf4j
public class ValidAuthInterceptor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        ValidAuth annotation = invocation.getMethod().getAnnotation(ValidAuth.class);
        if (annotation == null) {
            return invocation.proceed();
        }
        int role = annotation.hasRole();
        double random = Math.random();
        log.info("random is :"+random);
        int myRole = (int)(Math.floor(random*10) +1);
        if(myRole+1 > role){
            log.info("执行代理，修改userName...........");
            Object result = invocation.proceed();
            if(result instanceof UserEntity){
                ((UserEntity) result).setName("海绵宝宝");
            }
            return result;
        }
        throw new RuntimeException("权限不足，您的权限是："+myRole+",需要权限："+role);
    }
}
