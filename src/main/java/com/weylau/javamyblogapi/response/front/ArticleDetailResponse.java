package com.weylau.javamyblogapi.response.front;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.Date;

@Data
public class ArticleDetailResponse {
    @JSONField(name = "article_id")
    Integer articleId;

    @JSONField(name = "cate_id")
    Integer cateId;

    @JSONField(name = "title")
    String title;

    @JSONField(name = "description")
    String description;

    @JSONField(name = "keywords")
    String keywords;

    @JSONField(name = "img_path")
    String imgPath;

    @JSONField(name = "modify_time")
    Date modifyTime;

    @JSONField(name = "op_id")
    Integer opId;

    @JSONField(name = "op_user")
    String opUser;

    @JSONField(name = "create_time")
    Date createTime;

    @JSONField(name = "status")
    Integer status;

    @JSONField(name = "show_type")
    Integer showType;

    @JSONField(name = "contents")
    String contents;

}
