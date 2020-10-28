package com.weylau.javamyblogapi.controller.front;

import com.gitee.easyopen.ApiContext;
import com.gitee.easyopen.annotation.Api;
import com.gitee.easyopen.annotation.ApiService;
import com.weylau.javamyblogapi.request.front.ArticleDetailRequest;
import com.weylau.javamyblogapi.request.front.ArticleListRequest;
import com.weylau.javamyblogapi.response.front.ArticleDetailResponse;
import com.weylau.javamyblogapi.response.front.ArticleListResponse;
import com.weylau.javamyblogapi.response.front.CategoriesResponse;
import com.weylau.javamyblogapi.service.front.ArticlesService;
import com.weylau.javamyblogapi.service.front.CategoriesService;
import com.weylau.javamyblogapi.service.front.MqService;
import com.weylau.javamyblogapi.utils.ValidUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.List;

@ApiService
public class MqController extends BaseController{
    final static Logger logger = LoggerFactory.getLogger(MqController.class);


    @Autowired
    MqService mqService;



    /**
     * 获取文章列表
     *
     * @return
     */
    @Api(name="send")
    public void send() {
        mqService.send("test");
    }
}
