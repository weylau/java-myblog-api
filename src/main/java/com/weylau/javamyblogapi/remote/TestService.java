package com.weylau.javamyblogapi.remote;

import com.weylau.javamyblogapi.remote.config.DefaultConfig;
import com.weylau.javamyblogapi.remote.response.CategoriesResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "testService", configuration = DefaultConfig.class, url = "${test.service.url}")
public interface TestService {
    @RequestMapping(method = RequestMethod.GET, value = "/categories")
    CategoriesResponse queryCategories();
}
