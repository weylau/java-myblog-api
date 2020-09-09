package com.weylau.javamyblogapi.dao;

import com.weylau.javamyblogapi.model.Articles;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface ArticlesDao {
    Integer createArticle(Articles articles);
    Integer updateArticle(Integer articleId, Articles articles);
    List<Articles> getArticles(Integer offset, Integer pageSize, Integer cateId);
    Articles getDetailById(Integer articleId);
}

