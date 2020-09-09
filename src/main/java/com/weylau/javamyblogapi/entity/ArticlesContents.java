package com.weylau.javamyblogapi.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ArticlesContents implements Serializable {

    private Integer id;

    @JSONField(name = "article_id")
    private Integer articleId;
    @JSONField(name = "show_type")
    private Integer showType;

    private String contents;

    private static final long serialVersionUID = 1L;

}