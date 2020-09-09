package com.weylau.javamyblogapi.service.front;

import com.weylau.javamyblogapi.response.Response;

public interface ArticlesService {
    Response getList(Integer offset, Integer page_size, Integer cate_id);

    Response detail(Integer id);

//    Response getCategories();
}
