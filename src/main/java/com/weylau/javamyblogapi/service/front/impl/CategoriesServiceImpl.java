package com.weylau.javamyblogapi.service.front.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.weylau.javamyblogapi.cache.RedisClient;
import com.weylau.javamyblogapi.cache.RedisKey;
import com.weylau.javamyblogapi.entity.*;
import com.weylau.javamyblogapi.mapper.ArticlesCateMapper;
import com.weylau.javamyblogapi.mapper.ArticlesContentsMapper;
import com.weylau.javamyblogapi.mapper.ArticlesMapper;
import com.weylau.javamyblogapi.remote.service.TestRemoteService;
import com.weylau.javamyblogapi.response.front.CategoriesResponse;
import com.weylau.javamyblogapi.service.front.CategoriesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoriesServiceImpl implements CategoriesService {
    public final Logger logger = LoggerFactory.getLogger(CategoriesServiceImpl.class);

    @Autowired
    ArticlesMapper articlesMapper;

    @Autowired
    ArticlesContentsMapper articlesContentsMapper;

    @Autowired
    ArticlesCateMapper articlesCateMapper;

    @Autowired
    private RedisClient redisClient;

    @Autowired
    TestRemoteService testRemoteService;

    @Override
    public List<CategoriesResponse> getList() {
        //获取缓存
        String cacheKey = RedisKey.getKeyArticleCateList();
        String cacheDataStr = redisClient.get(cacheKey);
        List<ArticlesCate> articlesCateList;
        if (cacheDataStr != null && !"".equals(cacheDataStr)) {
            articlesCateList = JSONArray.parseArray(cacheDataStr, ArticlesCate.class);
        } else {
            ArticlesCateExample articlesCateExample = new ArticlesCateExample();
            articlesCateExample.setOrderByClause("orderby asc");
            articlesCateList = articlesCateMapper.selectByExample(articlesCateExample);
            JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(articlesCateList));
            redisClient.setNeverExpire(cacheKey, jsonArray.toJSONString());
        }
        List<CategoriesResponse> categoriesResponses = new ArrayList<>();
        articlesCateList.forEach(articlesCate -> {
            CategoriesResponse categoriesResponse = new CategoriesResponse();
            categoriesResponse.setCateId(articlesCate.getCateId());
            categoriesResponse.setCName(articlesCate.getCName());
            categoriesResponse.setName(articlesCate.getName());
            categoriesResponse.setOrderby(articlesCate.getOrderby());
            categoriesResponses.add(categoriesResponse);
        });
        return categoriesResponses;
    }

    @Override
    public List<CategoriesResponse> getListByApi() {
        List<com.weylau.javamyblogapi.remote.response.CategoriesResponse.Categories> articlesCateList = testRemoteService.queryCategories();
        List<CategoriesResponse> categoriesResponses = new ArrayList<>();
        articlesCateList.forEach(articlesCate -> {
            CategoriesResponse categoriesResponse = new CategoriesResponse();
            categoriesResponse.setCateId(articlesCate.getCateId());
            categoriesResponse.setCName(articlesCate.getCName());
            categoriesResponse.setName(articlesCate.getName());
            categoriesResponse.setOrderby(articlesCate.getOrderby());
            categoriesResponses.add(categoriesResponse);
        });
        return categoriesResponses;
    }

}
