package com.oxksusu.back.api.controller;

import com.oxksusu.back.api.service.dto.PostWriteDto;
import com.oxksusu.back.common.ApiResponse;
import com.oxksusu.back.api.entity.User;
import com.oxksusu.back.api.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public ApiResponse getUser() { // 유저 개인 정보 불러오기
        org.springframework.security.core.userdetails.User principal = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userService.getUser(principal.getUsername());

        return ApiResponse.success("user", user);
    }

    @GetMapping("/article/{userId}")// 한 사람이 쓴 게시글 전체 목록 조회 (최신순)
    public ApiResponse readPostList(@PathVariable String userId) {

        return ApiResponse.success("posts", userService.getAllPosts(userId));
    }

    @PostMapping("/write") // 게시글 작성
    public ApiResponse write(@RequestBody PostWriteDto writeDto) {

        String msg = userService.writePost(writeDto);

        return ApiResponse.success("msg", msg);
    }
}
