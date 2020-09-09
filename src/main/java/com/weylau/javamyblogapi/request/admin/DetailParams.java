package com.weylau.javamyblogapi.request.admin;

import lombok.Data;

import javax.validation.constraints.Min;

@Data
public class DetailParams {
    @Min(value = 1, message = "参数错误")
    Integer id;
}
