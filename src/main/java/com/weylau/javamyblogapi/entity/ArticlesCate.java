package com.weylau.javamyblogapi.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ArticlesCate implements Serializable {
    @JSONField(name = "cate_id")
    private Integer cateId;
    @JSONField(name = "name")
    private String name;
    @JSONField(name = "c_name")
    private String cName;
    @JSONField(name = "description")
    private String description;
    @JSONField(name = "parent_id")
    private Integer parentId;
    @JSONField(name = "orderby")
    private Integer orderby;
    @JSONField(name = "op_id")
    private Integer opId;
    @JSONField(name = "op_user")
    private String opUser;
    @JSONField(name = "create_time")
    private Date createTime;
    @JSONField(name = "modify_time")
    private Date modifyTime;

    private static final long serialVersionUID = 1L;


}