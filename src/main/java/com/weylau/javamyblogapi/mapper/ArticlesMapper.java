package com.weylau.javamyblogapi.mapper;

import com.weylau.javamyblogapi.entity.Articles;
import com.weylau.javamyblogapi.entity.ArticlesExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.RowBounds;

@Mapper
public interface ArticlesMapper {
    long countByExample(ArticlesExample example);

    int deleteByPrimaryKey(Integer articleId);

    int insert(Articles record);

    int insertSelective(Articles record);

    List<Articles> selectByExample(ArticlesExample example);

    Articles selectByPrimaryKey(Integer articleId);

    int updateByExampleSelective(@Param("record") Articles record, @Param("example") ArticlesExample example);

    int updateByExample(@Param("record") Articles record, @Param("example") ArticlesExample example);

    int updateByPrimaryKeySelective(Articles record);

    int updateByPrimaryKey(Articles record);
}