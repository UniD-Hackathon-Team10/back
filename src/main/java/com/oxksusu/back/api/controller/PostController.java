package com.oxksusu.back.api.controller;

import com.oxksusu.back.api.entity.Posts;
import com.oxksusu.back.api.service.dto.PostModifyDto;
import com.oxksusu.back.api.service.UserService;
import com.oxksusu.back.api.service.dto.PostWriteDto;
import com.oxksusu.back.common.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


@RestController
@RequestMapping("/api/v1/article")
@RequiredArgsConstructor
public class PostController {

    private final UserService userService;

    @GetMapping // 전체 게시글 목록 조회 (최신순)
    public ApiResponse readPostList() {

        List<Posts> posts = userService.getAllPosts();
        return ApiResponse.success("posts", posts);
    }

    @GetMapping("/{articleNo}") // 게시글 번호로 게시글 조회
    public ApiResponse readPost(@PathVariable Long articleNo) {
        return ApiResponse.success("posts", userService.getPosts(articleNo));
    }

    @GetMapping("/category/{category}")// 카테고리명으로 필터링
    public ApiResponse readCategory(@PathVariable String category) {

        return ApiResponse.success("posts", userService.getAllCategory(category));
    }

    @GetMapping("/search/{keyword}") // 책 제목으로 검색
    public ApiResponse searchKeyword(@PathVariable String keyword) {

        return ApiResponse.success("posts", userService.searchPost(keyword));
    }

}