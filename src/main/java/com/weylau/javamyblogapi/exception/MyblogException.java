package com.weylau.javamyblogapi.exception;

import com.gitee.easyopen.exception.ApiException;
import lombok.Data;

//Spring框架只会对抛出的异常是runtimeException时事物才会回滚
public class MyblogException extends ApiException {

    public MyblogException(String code, String message) {
        super(message, code);
    }
}
