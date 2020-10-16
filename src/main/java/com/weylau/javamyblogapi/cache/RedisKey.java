package com.weylau.javamyblogapi.cache;

import org.springframework.beans.factory.annotation.Value;

public class RedisKey {
    @Value("${redis_cache_key_version}")
    private static String REDIS_CACHE_KEY;
    private final static String KEY_ARTICLE_CATE_LIST = "article_cate_list_%s";

    public final static String getKeyArticleCateList() {
        return String.format(KEY_ARTICLE_CATE_LIST, REDIS_CACHE_KEY);
    }
}
