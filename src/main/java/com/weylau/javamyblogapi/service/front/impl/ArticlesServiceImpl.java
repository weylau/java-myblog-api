package com.weylau.javamyblogapi.service.front.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.weylau.javamyblogapi.entity.Articles;
import com.weylau.javamyblogapi.entity.ArticlesExample;
import com.weylau.javamyblogapi.mapper.ArticlesMapper;
import com.weylau.javamyblogapi.response.Response;
import com.weylau.javamyblogapi.service.front.ArticlesService;
import com.weylau.javamyblogapi.utils.ResponseUtil;
import com.weylau.javamyblogapi.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticlesServiceImpl implements ArticlesService {
    public final Logger logger = LoggerFactory.getLogger(ArticlesServiceImpl.class);

    @Autowired
    ArticlesMapper articlesMapper;


    @Override
    public Response getList(Integer page, Integer page_size, Integer cate_id) {
        ArticlesExample articlesExample = new ArticlesExample();
        ArticlesExample.Criteria criteria = articlesExample.createCriteria();
        if(cate_id > 0) {
            criteria.andCateIdEqualTo(cate_id);
        }
        PageHelper.startPage(page,page_size);
        List<Articles> articles = articlesMapper.selectByExample(articlesExample);
        //获取分页信息
        PageInfo<Articles> pageInfo = new PageInfo<Articles>(articles);
        long count  = pageInfo.getTotal();
        logger.info("page-total:"+count);
        return ResponseUtil.success(articles);
    }

    @Override
    public Response detail(Integer id) {
        String cacheKey = "article_detail_"+id;
        ArticlesExample articlesExample = new ArticlesExample();
        ArticlesExample.Criteria criteria = articlesExample.createCriteria();
        criteria.andArticleIdEqualTo(id);
        List<Articles> articles = articlesMapper.selectByExample(articlesExample);
        if(Utils.isEmpty(articles)) {
            return ResponseUtil.error(-1, "文章不存在！");
        }
        return ResponseUtil.success(articles.get(0));
    }


//    @Override
//    public Response getCategories() {
//        List<ArticlesCate> articleCate = articlesCateDao.getList();
//        return ResponseUtil.success(articleCate);
//    }
}
