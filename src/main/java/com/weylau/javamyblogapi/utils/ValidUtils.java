package com.weylau.javamyblogapi.utils;


import com.gitee.easyopen.exception.ApiException;
import com.weylau.javamyblogapi.exception.MyblogException;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import java.util.Set;

public class ValidUtils {
    public static <T> void validator(T object) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Set<ConstraintViolation<T>> constraintViolationSet = factory.getValidator().validate(object);
        if (constraintViolationSet.size() > 0) {
            constraintViolationSet.forEach(cons -> {
                throw new MyblogException("-1", cons.getMessage());
            });
        }
    }
}
