package com.weylau.javamyblogapi.mapper;

import com.weylau.javamyblogapi.entity.ArticlesCate;
import com.weylau.javamyblogapi.entity.ArticlesCateExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface ArticlesCateMapper {
    long countByExample(ArticlesCateExample example);

    int deleteByPrimaryKey(Integer cateId);

    int insert(ArticlesCate record);

    int insertSelective(ArticlesCate record);

    List<ArticlesCate> selectByExample(ArticlesCateExample example);

    ArticlesCate selectByPrimaryKey(Integer cateId);

    int updateByExampleSelective(@Param("record") ArticlesCate record, @Param("example") ArticlesCateExample example);

    int updateByExample(@Param("record") ArticlesCate record, @Param("example") ArticlesCateExample example);

    int updateByPrimaryKeySelective(ArticlesCate record);

    int updateByPrimaryKey(ArticlesCate record);
}