package com.oxksusu.back.api.entity.dto;

import com.oxksusu.back.api.entity.Posts;
import lombok.Data;

@Data
public class PostRequestDto {

    public String bookTitle;

    public String bookThumbnail;

    public String userId;

    public String content;

    public String author;

    public String nickname;

    public String category;

}
