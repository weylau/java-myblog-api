package com.weylau.javamyblogapi.handle;

import com.weylau.javamyblogapi.aspect.RequestLogAspect;
import com.weylau.javamyblogapi.exception.MyblogException;
import com.weylau.javamyblogapi.response.Response;
import com.weylau.javamyblogapi.utils.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

//@ControllerAdvice
public class ExceptionHandle {
    private final static Logger logger = LoggerFactory.getLogger(RequestLogAspect.class);

    //@ExceptionHandler(Exception.class)
    //@ResponseBody
    /*public Response handle(Exception e) {
        if(e instanceof MyblogException) {
            MyblogException myblogException = (MyblogException)e;
            return ResponseUtil.error(myblogException.getCode(),myblogException.getMessage());
        } else if(e instanceof BindException){
            return ResponseUtil.error(-1,((BindException) e).getFieldError().getDefaultMessage());
        }else {
            logger.info("【异常错误】{}",e);
            return ResponseUtil.error(-1, "未知错误");
        }
    }*/
}
