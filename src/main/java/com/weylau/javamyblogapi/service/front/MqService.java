package com.weylau.javamyblogapi.service.front;

import com.weylau.javamyblogapi.request.front.ArticleDetailRequest;
import com.weylau.javamyblogapi.request.front.ArticleListRequest;
import com.weylau.javamyblogapi.response.front.ArticleDetailResponse;
import com.weylau.javamyblogapi.response.front.ArticleListResponse;

import java.util.List;

public interface MqService {
    void send(String msg);
}
