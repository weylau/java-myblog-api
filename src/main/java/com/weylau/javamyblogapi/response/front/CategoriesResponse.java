package com.weylau.javamyblogapi.response.front;

import com.alibaba.fastjson.annotation.JSONField;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class CategoriesResponse {
    @JSONField(name = "cate_id")
    Integer cateId;

    @JSONField(name = "name")
    String name;

    @JSONField(name = "c_name")
    String cName;

    @JSONField(name = "orderby")
    Integer orderby;
}
