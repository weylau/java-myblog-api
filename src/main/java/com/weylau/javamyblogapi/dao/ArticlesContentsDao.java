package com.weylau.javamyblogapi.dao;

import com.weylau.javamyblogapi.model.Articles;
import com.weylau.javamyblogapi.model.ArticlesContents;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
public interface ArticlesContentsDao {
    Integer createArticleContent(ArticlesContents articlesContents);
    ArticlesContents getByArticleId(Integer articleId);
    Integer updateArticleContent(Integer articleId, ArticlesContents articlesContents);
}

