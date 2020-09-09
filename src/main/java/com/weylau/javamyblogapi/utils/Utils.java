package com.weylau.javamyblogapi.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.serializer.SerializeConfig;

import java.util.Collection;

public class Utils {
    public static String objToJsonString(Object object) {
        SerializeConfig config = new SerializeConfig();
        config.propertyNamingStrategy = PropertyNamingStrategy.SnakeCase;
        return JSON.toJSONString(object, config);
    }

    public static boolean isEmpty(Collection coll) {
        return coll == null || coll.isEmpty();
    }
}
