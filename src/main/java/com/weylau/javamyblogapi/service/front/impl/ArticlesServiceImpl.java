package com.weylau.javamyblogapi.service.front.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.weylau.javamyblogapi.entity.Articles;
import com.weylau.javamyblogapi.entity.ArticlesContents;
import com.weylau.javamyblogapi.entity.ArticlesContentsExample;
import com.weylau.javamyblogapi.entity.ArticlesExample;
import com.weylau.javamyblogapi.exception.MyblogException;
import com.weylau.javamyblogapi.mapper.ArticlesContentsMapper;
import com.weylau.javamyblogapi.mapper.ArticlesMapper;
import com.weylau.javamyblogapi.request.front.ArticleDetailRequest;
import com.weylau.javamyblogapi.request.front.ArticleListRequest;
import com.weylau.javamyblogapi.response.Response;
import com.weylau.javamyblogapi.response.front.ArticleDetailResponse;
import com.weylau.javamyblogapi.response.front.ArticleListResponse;
import com.weylau.javamyblogapi.service.front.ArticlesService;
import com.weylau.javamyblogapi.utils.ResponseUtil;
import com.weylau.javamyblogapi.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ArticlesServiceImpl implements ArticlesService {
    public final Logger logger = LoggerFactory.getLogger(ArticlesServiceImpl.class);

    @Autowired
    ArticlesMapper articlesMapper;

    @Autowired
    ArticlesContentsMapper articlesContentsMapper;


    @Override
    public List<ArticleListResponse> getList(ArticleListRequest articleListRequest) {
        ArticlesExample articlesExample = new ArticlesExample();
        ArticlesExample.Criteria criteria = articlesExample.createCriteria();
        if(articleListRequest.getCateId() > 0) {
            criteria.andCateIdEqualTo(articleListRequest.getCateId());
        }
        PageHelper.startPage(articleListRequest.getPage(),articleListRequest.getPageSize());
        List<Articles> articles = articlesMapper.selectByExample(articlesExample);
        List<ArticleListResponse> articleListResponses = new ArrayList<>();
        articles.forEach(article -> {
            ArticleListResponse articleListResponse = new ArticleListResponse();
            articleListResponse.setArticleId(article.getArticleId());
            articleListResponse.setCateId(article.getCateId());
            articleListResponse.setCreateTime(article.getCreateTime());
            articleListResponse.setDescription(article.getDescription());
            articleListResponse.setImgPath(article.getImgPath());
            articleListResponse.setKeywords(article.getKeywords());
            articleListResponse.setModifyTime(article.getModifyTime());
            articleListResponse.setOpId(article.getOpId());
            articleListResponse.setOpUser(article.getOpUser());
            articleListResponse.setStatus(article.getStatus());
            articleListResponse.setTitle(article.getTitle());
            articleListResponses.add(articleListResponse);
        });
        //获取分页信息
        PageInfo<Articles> pageInfo = new PageInfo<Articles>(articles);
        long count  = pageInfo.getTotal();
        logger.info("page-total:"+count);
        return articleListResponses;
    }

    @Override
    public ArticleDetailResponse detail(ArticleDetailRequest articleDetailRequest) {
        String cacheKey = "article_detail_"+articleDetailRequest.getId();
        Articles article = articlesMapper.selectByPrimaryKey(articleDetailRequest.getId());
        ArticlesContentsExample articlesContentsExample = new ArticlesContentsExample();
        ArticlesContentsExample.Criteria criteria = articlesContentsExample.createCriteria();
        criteria.andArticleIdEqualTo(articleDetailRequest.getId());
        List<ArticlesContents> articlesContents = articlesContentsMapper.selectByExampleWithBLOBs(articlesContentsExample);

        Optional<Articles> articlesOptional = Optional.ofNullable(article);
        if(!articlesOptional.isPresent() || articlesContents.size() <= 0) {
            throw new MyblogException("-1", "文章不存在！");
        }
        article = articlesOptional.get();
        ArticleDetailResponse articleDetailResponse = new ArticleDetailResponse();
        articleDetailResponse.setArticleId(article.getArticleId());
        articleDetailResponse.setCateId(article.getCateId());
        articleDetailResponse.setCreateTime(article.getCreateTime());
        articleDetailResponse.setDescription(article.getDescription());
        articleDetailResponse.setImgPath(article.getImgPath());
        articleDetailResponse.setKeywords(article.getKeywords());
        articleDetailResponse.setModifyTime(article.getModifyTime());
        articleDetailResponse.setOpId(article.getOpId());
        articleDetailResponse.setOpUser(article.getOpUser());
        articleDetailResponse.setStatus(article.getStatus());
        articleDetailResponse.setTitle(article.getTitle());
        articleDetailResponse.setContents(articlesContents.get(0).getContents());
        return articleDetailResponse;
    }


//    @Override
//    public Response getCategories() {
//        List<ArticlesCate> articleCate = articlesCateDao.getList();
//        return ResponseUtil.success(articleCate);
//    }
}
