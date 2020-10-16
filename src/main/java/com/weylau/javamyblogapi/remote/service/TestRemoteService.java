package com.weylau.javamyblogapi.remote.service;

import com.alibaba.fastjson.JSONObject;
import com.weylau.javamyblogapi.exception.MyblogException;
import com.weylau.javamyblogapi.remote.TestService;
import com.weylau.javamyblogapi.remote.response.CategoriesResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TestRemoteService{
    private static final Logger logger = LoggerFactory.getLogger(TestRemoteService.class);
    @Autowired
    TestService testService;

    public List<CategoriesResponse.Categories> queryCategories() {
        CategoriesResponse response = null;
        try {
            response = testService.queryCategories();;
        } catch (Exception e) {
            logger.error("TestRemoteService queryCategories occur exception:{}", e);
            throw e;
        }
        if (response == null || response.getRet() != 0 || response.getData() == null) {
            logger.error("OpsPanelIntegrationService queryAreaIdsByLocation response error, response:{}", JSONObject.toJSONString(response));
            throw new MyblogException("-1", "接口调用失败");
        }
        logger.info("TestRemoteService queryCategories response:{}", JSONObject.toJSONString(response));
        return response.getData();
    }
}
