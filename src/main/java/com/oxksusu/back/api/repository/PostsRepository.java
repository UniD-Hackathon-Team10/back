package com.oxksusu.back.api.repository;

import com.oxksusu.back.api.entity.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;

@Repository
public interface PostsRepository extends JpaRepository<Posts, Long> {
    @Query(value = "SELECT * FROM posts p join book_table b on p.book_title = b.book_title where p.article_no = ?1", nativeQuery = true)
    Posts findPostDetail(Long article_no);

    @Modifying(clearAutomatically = true)
    @Query(value = "INSERT INTO posts(author,book_thumbnail,book_title,category,content,nickname,user_id) VALUES (?1,?2,?3,?4,?5,?6,?7)", nativeQuery = true)
    void savePost(String author, String bookTumbnail, String bookTitle, String category, String content, String nickname, String userId);

    List<Posts> findAllByUserId(String userId);

    Posts findByUserId(String userId);

    List<Posts> findAllByCategory(String category);

    List<Posts> findAllByBookTitle(String keyword);
}
