package com.weylau.javamyblogapi.request.front;

import lombok.Data;

import javax.validation.constraints.Min;

@Data
public class ArticleDetailRequest {
    @Min(value = 1, message = "id参数错误")
    Integer id;
}
