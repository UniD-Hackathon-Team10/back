package com.oxksusu.back.api.controller;

import com.oxksusu.back.api.service.dto.PostModifyDto;
import com.oxksusu.back.api.service.UserService;
import com.oxksusu.back.api.service.dto.PostWriteDto;
import com.oxksusu.back.common.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


// 요청으로 author 정보가 넘어오면 게시글 정보를 읽어옵니다.
@RestController
@RequestMapping("/api/v1/article")
@RequiredArgsConstructor
public class PostController {

    private final UserService userService;

    @GetMapping() // 전체 게시글 목록 조회 (최신순)
    public ApiResponse readPostList() {
        return ApiResponse.success("posts", userService.getPosts());
    }

    @GetMapping() // 한 사람이 쓴 게시글 전체 목록 조회 (최신순)
    public ApiResponse readPostList(HttpServletRequest request,
                                    HttpServletResponse response,
                                    @RequestParam("nickname") String nickname) {

        return ApiResponse.success("posts", userService.getPostsByNickname(nickname));
    }

    @GetMapping() // 게시글 번호로 게시글 조회
    public ApiResponse readPost(HttpServletRequest request,
                                HttpServletResponse response,
                                @RequestParam("articleNo") Long articleNo) {
        return ApiResponse.success("posts", userService.getPostByArticleNo(articleNo));
    }

    @PostMapping("/modify") // 게시글 번호로 게시글 수정
    public ApiResponse modifyPost(HttpServletRequest request,
                                  HttpServletResponse response,
                                  @RequestParam("articleNo") Long articleNo,
                                  @RequestBody PostModifyDto modifyDto) {

        String msg = userService.modifyPost(articleNo, modifyDto);

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