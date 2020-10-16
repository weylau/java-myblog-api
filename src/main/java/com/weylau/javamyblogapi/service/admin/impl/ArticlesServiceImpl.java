package com.weylau.javamyblogapi.service.admin.impl;

import com.weylau.javamyblogapi.entity.Articles;
import com.weylau.javamyblogapi.entity.ArticlesContents;
import com.weylau.javamyblogapi.entity.ArticlesContentsExample;
import com.weylau.javamyblogapi.exception.MyblogException;
import com.weylau.javamyblogapi.mapper.ArticlesContentsMapper;
import com.weylau.javamyblogapi.mapper.ArticlesMapper;
import com.weylau.javamyblogapi.response.Response;
import com.weylau.javamyblogapi.service.admin.ArticlesService;
import com.weylau.javamyblogapi.utils.ResponseUtil;
import com.weylau.javamyblogapi.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service("adminArticlesService")
public class ArticlesServiceImpl implements ArticlesService {
    final Logger logger = LoggerFactory.getLogger(ArticlesServiceImpl.class);
    @Autowired
    ArticlesMapper articlesMapper;

    @Autowired
    ArticlesContentsMapper articlesContentsMapper;

    @Transactional
    @Override
    public Response create(Map params) {
        Date now = new Date();
        Articles articles = Articles.builder()
                .cateId(Integer.parseInt(params.get("cate_id").toString()))
                .status(Integer.parseInt(params.get("status").toString()))
                .title(params.get("title").toString())
                .description(params.get("descreption").toString())
                .keywords(params.get("keywords").toString())
                .imgPath(params.get("img_path").toString())
                .modifyTime(now)
                .opId(1)
                .opUser("admin")
                .createTime(now)
                .build();
        articlesMapper.insert(articles);

        ArticlesContents articlesContents = ArticlesContents.builder()
                .articleId(articles.getArticleId())
                .contents(params.get("contents").toString())
                .showType(Integer.parseInt(params.get("show_type").toString()))
                .build();
        articlesContentsMapper.insert(articlesContents);
        return ResponseUtil.success();
    }

    @Transactional
    @Override
    public Response update(
            Integer id,
            Map params
    ) {
        ArticlesContentsExample articlesContentsExample = new ArticlesContentsExample();
        ArticlesContentsExample.Criteria criteria = articlesContentsExample.createCriteria();
        criteria.andArticleIdEqualTo(id);
        //查找文章是否存在
        Optional<Articles> info = Optional.ofNullable(articlesMapper.selectByPrimaryKey(id));
        List<ArticlesContents> list = articlesContentsMapper.selectByExample(articlesContentsExample);
        if (info.isPresent() && !Utils.isEmpty(list)) {
            Date now = new Date();
            Articles articles = Articles.builder()
                    .articleId(id)
                    .cateId(Integer.parseInt(params.get("cate_id").toString()))
                    .status(Integer.parseInt(params.get("status").toString()))
                    .title(params.get("title").toString())
                    .description(params.get("descreption").toString())
                    .keywords(params.get("keywords").toString())
                    .imgPath(params.get("img_path").toString())
                    .modifyTime(now)
                    .opId(1)
                    .opUser("admin")
                    .build();
            articlesMapper.updateByPrimaryKey(articles);

            ArticlesContents articlesContents = ArticlesContents.builder()
                    .id(list.get(0).getId())
                    .articleId(articles.getArticleId())
                    .contents(params.get("contents").toString())
                    .showType(Integer.parseInt(params.get("show_type").toString()))
                    .build();
            articlesContentsMapper.updateByPrimaryKey(articlesContents);
            return ResponseUtil.success();
        } else {
            throw new MyblogException("-1", "文章不存在！");
        }

    }
//
//    @Override
//    public Response detail(
//            Integer id
//    ) {
//        Optional<Articles> info = Optional.ofNullable(articlesDao.getDetailById(id));
//        //Optional<ArticlesContents> contentInfo = Optional.ofNullable(articlesContentsDao.getByArticleId(id));
//        if (info.isPresent()) {
//            return ResponseUtil.success(info.get());
//        } else {
//            throw new MyblogException(-1, "文章不存在！");
//        }
//    }
//
//    @Override
//    public Response getList(Integer offset, Integer page_size, Integer cate_id) {
//        List<Articles> articles = articlesDao.getArticles(offset, page_size, cate_id);
//        return ResponseUtil.success(articles);
//    }
}
