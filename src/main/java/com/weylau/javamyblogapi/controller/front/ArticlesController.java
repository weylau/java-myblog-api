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
import com.weylau.javamyblogapi.utils.ValidUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.List;

@ApiService
public class ArticlesController extends BaseController{
    final static Logger logger = LoggerFactory.getLogger(ArticlesController.class);

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Autowired
    ArticlesService articlesService;

    @Autowired
    CategoriesService categoriesService;


    /**
     * 获取文章列表
     *
     * @return
     */
    @Api(name="articles")
    public List<ArticleListResponse> list() {
        ArticleListRequest articleListRequest = new ArticleListRequest();
        articleListRequest.setCateId(ApiContext.getApiParam().getInteger("cate_id"));
        articleListRequest.setPage(ApiContext.getApiParam().getInteger("page"));
        articleListRequest.setPageSize(ApiContext.getApiParam().getInteger("page_size"));
        ValidUtils.validator(articleListRequest);
        logger.info("testlog:"+articleListRequest.toString());
        return articlesService.getList(articleListRequest);
    }

    /**
     * 获取文章列表
     *
     * @return
     */
    @Api(name="categories")
    public List<CategoriesResponse> categories() {
//        return categoriesService.getList();
        return categoriesService.getListByApi();
    }

    /**
     * test
     *
     * @return
     */
    @Api(name="logtest")
    public void logtest() {
        logger.debug( "debug log..." );
        logger.info( "info log..." );
        logger.warn( "warn log..." );
    }

    /**
     * 获取文章详情
     *
     * @return
     */
    @Api(name="article")
    public ArticleDetailResponse detail() {
        ArticleDetailRequest articleDetailRequest = new ArticleDetailRequest();
        articleDetailRequest.setId(ApiContext.getApiParam().getInteger("id"));
        ValidUtils.validator(articleDetailRequest);
        return articlesService.detail(articleDetailRequest);
    }
}
