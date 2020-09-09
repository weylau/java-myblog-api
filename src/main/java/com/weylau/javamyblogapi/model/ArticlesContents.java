package com.weylau.javamyblogapi.model;

import java.io.Serializable;

public class ArticlesContents implements Serializable {
    private Integer id;

    private Integer articleId;

    private Byte showType;

    private String contents;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public Byte getShowType() {
        return showType;
    }

    public void setShowType(Byte showType) {
        this.showType = showType;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents == null ? null : contents.trim();
    }
}