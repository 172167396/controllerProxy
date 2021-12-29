package com.dailu.methodenhance;

import com.dailu.methodenhance.config.ValidAuthConfig;
import com.dailu.methodenhance.interceptor.ControllerAdvisor;
import com.dailu.methodenhance.interceptor.ValidAuthInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

@SpringBootApplication
//@Import(ValidAuthConfig.class)
public class MethodEnhanceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MethodEnhanceApplication.class, args);
    }

    @Bean
    @ConditionalOnMissingBean
    public ControllerAdvisor controllerAdvisor(){
        ValidAuthInterceptor interceptor = new ValidAuthInterceptor();
        ControllerAdvisor controllerAdvisor = new ControllerAdvisor(interceptor);
        controllerAdvisor.setOrder(1);
        return controllerAdvisor;
    }
}
