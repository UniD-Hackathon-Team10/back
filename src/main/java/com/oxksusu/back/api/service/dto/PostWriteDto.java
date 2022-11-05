package com.oxksusu.back.api.service.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class PostWriteDto {

    public Long userId;

    public String nickname;

    public String author;

    public String category;

    public String bookTitle;

    public String content;

    public String bookThumbnail;

}
