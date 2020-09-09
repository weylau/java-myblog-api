package com.weylau.javamyblogapi.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonAutoDetect
public class Articles implements Serializable {
    @JSONField(name = "article_id")
    private Integer articleId;
    @JSONField(name = "cate_id")
    private Integer cateId;
    @JSONField(name = "title")
    private String title;
    @JSONField(name = "status")
    private Integer status;
    @JSONField(name = "description")
    private String description;
    @JSONField(name = "keywords")
    private String keywords;
    @JSONField(name = "img_path")
    private String imgPath;
    @JSONField(name = "op_id")
    private Integer opId;
    @JSONField(name = "op_user")
    private String opUser;
    @JSONField(name = "create_time")
    private Date createTime;
    @JSONField(name = "modify_time")
    private Date modifyTime;

    private static final long serialVersionUID = 1L;


}