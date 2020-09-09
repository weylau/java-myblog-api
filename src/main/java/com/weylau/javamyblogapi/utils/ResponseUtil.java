package com.weylau.javamyblogapi.utils;

import com.weylau.javamyblogapi.response.Response;

public class ResponseUtil {
    public static Response success(Object object) {
        Response response = new Response();
        response.setRet(0);
        response.setMsg("success");
        response.setData(object);
        return response;
    }

    public static Response success() {
        Response response = new Response();
        response.setRet(0);
        response.setMsg("success");
        response.setData("");
        return response;
    }

    public static Response error(Integer ret, String msg) {
        Response response = new Response();
        response.setRet(ret);
        response.setMsg(msg);
        return response;
    }
}
