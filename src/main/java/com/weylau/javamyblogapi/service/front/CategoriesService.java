package com.weylau.javamyblogapi.service.front;

import com.weylau.javamyblogapi.request.front.ArticleDetailRequest;
import com.weylau.javamyblogapi.request.front.ArticleListRequest;
import com.weylau.javamyblogapi.response.front.ArticleDetailResponse;
import com.weylau.javamyblogapi.response.front.ArticleListResponse;
import com.weylau.javamyblogapi.response.front.CategoriesResponse;

import java.util.List;

public interface CategoriesService {
    List<CategoriesResponse> getList();
    List<CategoriesResponse> getListByApi();
}
