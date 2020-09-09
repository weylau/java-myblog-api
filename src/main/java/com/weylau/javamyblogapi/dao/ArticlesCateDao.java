package com.weylau.javamyblogapi.dao;

import com.weylau.javamyblogapi.model.ArticlesCate;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticlesCateDao {
    List<ArticlesCate> getList();
}

