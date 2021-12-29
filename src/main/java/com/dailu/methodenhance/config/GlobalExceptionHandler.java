package com.dailu.methodenhance.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public Map<String,Object> errorHandler(RuntimeException e){
        log.error(e.getMessage(),e);
        Map<String,Object> map = new HashMap<>();
        map.put("code","500");
        map.put("msg",e.getMessage());
        return map;
    }
}
