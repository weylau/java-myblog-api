package com.weylau.javamyblogapi.entity.mongo;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document
@Builder
public class AccessLog {
    @Id
    private String id;
    private String ip;
    private Date date;
    private String urlPath;
}
