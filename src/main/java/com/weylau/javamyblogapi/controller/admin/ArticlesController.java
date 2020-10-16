package com.weylau.javamyblogapi.controller.admin;

import com.weylau.javamyblogapi.request.front.ArticleListRequest;
import com.weylau.javamyblogapi.response.Response;
import com.weylau.javamyblogapi.response.front.ArticleListResponse;
import com.weylau.javamyblogapi.service.front.ArticlesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.Map;

@RestController("adminArticlesController")
public class ArticlesController extends BaseController {

    public final static Logger logger = LoggerFactory.getLogger(ArticlesController.class);

    @Autowired
    ArticlesService articlesService;

    /**
     * 创建文章
     *
     * @return
     */
//    @PostMapping(value = "/article", produces = "application/json;charset=UTF-8")
//    @Transactional
//    public Response create(
//            @RequestBody Map params
//    ) {
//        return articlesService.create(params);
//    }
//
//    /**
//     * 更新文章
//     */
//    @PutMapping(value = "/article/{id}", produces = "application/json;charset=UTF-8")
//    public Response update(
//            @RequestBody Map params,
//            @PathVariable(value = "id", required = true) Integer id
//    ) {
//        return articlesService.update(id, params);
//    }

//    /**
//     * 获取文章详情
//     *
//     * @return
//     */
//    @GetMapping("/article/{id}")
//    public Response detail(
//            @Valid ArticleDetailRequest detailParams
//    ) {
//        return articlesService.detail(detailParams.getId());
//    }
}
