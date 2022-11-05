package com.oxksusu.back.api.service;

import com.oxksusu.back.api.entity.Book;
import com.oxksusu.back.api.entity.Posts;
import com.oxksusu.back.api.entity.User;
import com.oxksusu.back.api.repository.BookRepository;
import com.oxksusu.back.api.repository.PostsRepository;
import com.oxksusu.back.api.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    private final PostsRepository postsRepository;

    private final BookRepository bookRepository;
    // 사용자 정보
    public User getUser(String userId) {
        return userRepository.findByUserId(userId);
    }

    // 전체 게시글 조회 (최신순)
    public List<Posts> getAllPosts() {
        return postsRepository.findAll();
    }

    // 사용자 한 명 전체 게시글 조회
    public List<Posts> getAllPosts(String userId) {
        return postsRepository.findAllByUserId(userId);
    }

    public Posts getPosts(Long articleNo) {
        return postsRepository.findById(articleNo).orElseThrow();
    }

    public List<Posts> getAllCategory(String category) {
        return postsRepository.findAllByCategory(category);
    }

    public Posts getPostByArticleNo(Long articleNo) {
        return postsRepository.findPostDetail(articleNo);
    }

    public List<Posts> searchPost(String keyword) {

        return postsRepository.findAllByBookTitle(keyword);
    }

//
//    public Posts getPostByArticleNo(Long articleNo) {
//        return postsRepository.findById(articleNo)
//                .orElseThrow();
//    }
//
//    public String modifyPost(PostModifyDto modifyDto) {
//
//        Posts posts = postsRepository.findByUserId(modifyDto.getUserId());
//        posts.update(modifyDto.getBookTitle(), modifyDto.getContent());
//        postsRepository.save(posts);
//
//        return ("게시글 수정에 성공하였습니다.");
//    }

    @Transactional
    public void writePost(Posts posts) {

        postsRepository.save(posts);
    }

    public List<Book> searchBookInfo() {
        return bookRepository.findAll();
    }

    public Book searchBookInfo(String keyword) {

        return bookRepository.findByBookTitle(keyword);
    }
}
