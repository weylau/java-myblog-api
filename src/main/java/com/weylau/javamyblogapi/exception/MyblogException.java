package com.weylau.javamyblogapi.exception;

import lombok.Data;

//Spring框架只会对抛出的异常是runtimeException时事物才会回滚
@Data
public class MyblogException extends RuntimeException{
    private Integer code;

    public MyblogException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
