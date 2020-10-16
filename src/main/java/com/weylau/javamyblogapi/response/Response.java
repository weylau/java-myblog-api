package com.weylau.javamyblogapi.response;

import com.alibaba.fastjson.annotation.JSONField;
import com.gitee.easyopen.Result;
import lombok.Data;

@Data
public class Response<T> implements Result {
    @JSONField(name = "ret")
    private Integer ret;
    @JSONField(name = "msg")
    private String msg;
    @JSONField(name = "data")
    private T data;

    @Override
    public void setCode(Object code){
        this.setRet(Integer.valueOf(code.toString()));
    }

    @Override
    public void setMsg(String var1){
        this.msg = var1;
    }

    @Override
    public void setData(Object var1){
        this.data = (T) var1;
    }


}
