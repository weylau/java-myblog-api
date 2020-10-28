package com.weylau.javamyblogapi.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.gitee.easyopen.ApiConfig;
import com.gitee.easyopen.serializer.JsonResultSerializer;
import com.gitee.easyopen.support.ApiController;
import com.weylau.javamyblogapi.response.MyResultCreator;
import com.weylau.javamyblogapi.response.Response;
import org.springframework.stereotype.Controller;

@Controller
public class IndexController extends ApiController {
    @Override
    protected void initApiConfig(ApiConfig apiConfig) {
        apiConfig.setAppName("java-myblog-api"); // 配置应用名称
        apiConfig.setAppKeyName("appid"); // 配置appkey的请求参数
        apiConfig.setShowDoc(true); // 显示文档页面
        apiConfig.setResultCreator(new MyResultCreator());//自定义结果返回

        apiConfig.setIgnoreValidate(true); // 所有接口的签名认证操作都将忽略（业务参数校验除外）
        apiConfig.setApiName("");
        apiConfig.setVersionName("");
        // Json返回结果反序列化格式, 默认蛇形命名
        apiConfig.setJsonResultSerializer(new JsonResultSerializer(){
            @Override
            public String serialize(Object obj) {
                return JSON.toJSONString(obj, SerializerFeature.WriteMapNullValue,SerializerFeature.WriteNullStringAsEmpty);
            }
        });

    }
}
