package com.weylau.javamyblogapi.aspect;

import com.weylau.javamyblogapi.entity.mongo.AccessLog;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Component
@Aspect
@Slf4j
public class RequestLogAspect {
    /*@Autowired
    private MongoTemplate mongoTemplate;*/

    @Pointcut("execution(public * com.weylau.javamyblogapi.controller.*.*.*(..))")
    public void init() {
    }

    @Before("init()")
    public void before(JoinPoint joinPoint) {
        /*new Thread(){
            @Override
            public void run() {
                ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
                assert servletRequestAttributes != null;
                HttpServletRequest httpServletRequest = servletRequestAttributes.getRequest();

                AccessLog accessLog = AccessLog.builder()
                        .ip(httpServletRequest.getRemoteAddr())
                        .date(new Date())
                        .urlPath(httpServletRequest.getRequestURL().toString())
                        .build();
                mongoTemplate.save(accessLog);
            }
        }.start();*/

    }

    @AfterReturning(pointcut = "init()", returning = "object")
    public void afterReturning(Object object) {
        if(object instanceof Object) {
            log.info("response={}", object.toString());
        }
    }


}
