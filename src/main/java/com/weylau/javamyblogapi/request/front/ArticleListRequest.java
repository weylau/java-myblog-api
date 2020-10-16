package com.weylau.javamyblogapi.request.front;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.Min;

@Data
public class ArticleListRequest {

    @Min(value = 1, message = "page参数错误")
    Integer page;


    @Min(value = 1, message = "page_size参数错误")
    Integer pageSize;


    @Min(value = 0,message = "cate_id参数错误")
    Integer cateId;
}
