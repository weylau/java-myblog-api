package com.weylau.javamyblogapi.remote.config;

import feign.Contract;
import feign.Logger;
import feign.codec.Decoder;
import feign.codec.Encoder;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import org.springframework.cloud.openfeign.support.SpringMvcContract;
import org.springframework.context.annotation.Bean;

public class DefaultConfig {
    @Bean
    Logger serviceClientLogger() {
        return new Logger.ErrorLogger();
    }

    @Bean
    Logger.Level serviceClientLoggerLevel() {
        return Logger.Level.BASIC;
    }

    @Bean
    Decoder serviceClientDecoder() {
        return new GsonDecoder();
    }

    @Bean
    Encoder serviceClientEncoder() {
        return new GsonEncoder();
    }

    @Bean
    Contract feignContract() {
        return new SpringMvcContract();
    }
}
