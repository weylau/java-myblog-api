package com.weylau.javamyblogapi.response;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

@Data
public class Response<T>{
    @JSONField(name = "ret")
    private Integer ret;
    @JSONField(name = "msg")
    private String msg;
    @JSONField(name = "data")
    private T data;

}
