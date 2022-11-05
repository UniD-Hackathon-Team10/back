package com.oxksusu.back.api.service.dto;

import lombok.Data;


@Data
public class PostModifyDto {

    public Long userId;
    public String nickname;
    public String bookTitle;
    public String content;
}
