package com.weylau.javamyblogapi.remote.response;

import com.alibaba.fastjson.annotation.JSONField;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.List;


@Data
public class CategoriesResponse {
    private int ret;
    private String msg;
    private List<Categories> data;

    @Data
    public static class Categories {
        @SerializedName("cate_id")
        Integer cateId;
        String name;
        @SerializedName("c_name")
        String cName;
        Integer orderby;
    }
}
