package com.weylau.javamyblogapi.response;

import com.gitee.easyopen.Result;
import com.gitee.easyopen.ResultCreator;

public class MyResultCreator implements ResultCreator {
    @Override
    public Result createResult(Object returnObj) {
        Response ret = new Response<>();
        ret.setCode(0);
        ret.setData(returnObj);
        return ret;
    }

    @Override
    public Result createErrorResult(Object code, String errorMsg, Object data) {
        Response ret = new Response();
        ret.setCode(code);
        ret.setMsg(errorMsg);
        ret.setData(data);
        return ret;
    }
}
