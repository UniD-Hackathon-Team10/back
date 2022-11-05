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


// 요청으로 author 정보가 넘어오면 게시글 정보를 읽어옵니다.
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class PostController {

    private final UserService userService;

    @GetMapping("/article") // 전체 게시글 목록 조회 (최신순)
    public ApiResponse readPostList() {

        List<Posts> posts = userService.getPosts();
        return ApiResponse.success("posts", posts);
    }

    @GetMapping("/article/{userId}")// 한 사람이 쓴 게시글 전체 목록 조회 (최신순)
    public ApiResponse readPostList(HttpServletRequest request,
                                    HttpServletResponse response,
                                    @PathVariable String userId) {

        Long LUserId = Long.parseLong(userId);

        return ApiResponse.success("posts", userService.getPostsByUserId(LUserId));
    }

    @GetMapping("/article/{articleNo}") // 게시글 번호로 게시글 조회
    public ApiResponse readPost(HttpServletRequest request,
                                HttpServletResponse response,
                                @PathVariable Long articleNo) {
        return ApiResponse.success("posts", userService.getPostByArticleNo(articleNo));
    }

    @PostMapping("/modify") // 게시글 번호로 게시글 수정
    public ApiResponse modifyPost(@RequestBody PostModifyDto modifyDto) {

        String msg = userService.modifyPost(modifyDto);

        return ApiResponse.success("msg", msg);
    }

    @PostMapping("/write") // 게시글 작성
    public ApiResponse write(HttpServletRequest request,
                             HttpServletResponse response,
                             @RequestBody PostWriteDto writeDto) {

        String msg = userService.writePost(writeDto);

        return ApiResponse.success("msg", msg);
    }

}