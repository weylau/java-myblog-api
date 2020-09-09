package com.weylau.javamyblogapi.mapper;

import com.weylau.javamyblogapi.entity.ArticlesContents;
import com.weylau.javamyblogapi.entity.ArticlesContentsExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface ArticlesContentsMapper {
    long countByExample(ArticlesContentsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ArticlesContents record);

    int insertSelective(ArticlesContents record);

    List<ArticlesContents> selectByExampleWithBLOBs(ArticlesContentsExample example);

    List<ArticlesContents> selectByExample(ArticlesContentsExample example);

    ArticlesContents selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ArticlesContents record, @Param("example") ArticlesContentsExample example);

    int updateByExampleWithBLOBs(@Param("record") ArticlesContents record, @Param("example") ArticlesContentsExample example);

    int updateByExample(@Param("record") ArticlesContents record, @Param("example") ArticlesContentsExample example);

    int updateByPrimaryKeySelective(ArticlesContents record);

    int updateByPrimaryKeyWithBLOBs(ArticlesContents record);

    int updateByPrimaryKey(ArticlesContents record);
}