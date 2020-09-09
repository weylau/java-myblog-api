package com.weylau.javamyblogapi.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class Admins implements Serializable {
    private Integer adminId;

    private String username;

    private String password;

    private Boolean status;

    private Integer opId;

    private String opUser;

    private Date createTime;

    private Date modifyTime;

    private static final long serialVersionUID = 1L;
}