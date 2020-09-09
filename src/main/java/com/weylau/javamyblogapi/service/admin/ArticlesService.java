package com.weylau.javamyblogapi.service.admin;

import com.weylau.javamyblogapi.response.Response;
import java.util.Map;

public interface ArticlesService {
    Response create(Map params) ;

    Response update(Integer id,Map params) ;
//
//    Response detail(Integer id) ;
//
//    Response getList(Integer offset, Integer page_size, Integer cate_id);
}
