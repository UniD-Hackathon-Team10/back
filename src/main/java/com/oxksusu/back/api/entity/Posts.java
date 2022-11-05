package com.oxksusu.back.api.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "POSTS")
public class Posts extends BaseTimeEntity {

    @JsonIgnore
    @Id
    @Column(name = "ARTICLE_NO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long articleNo;

    @Column(name = "USER_ID", length = 64, unique = true)
    @NotNull
    public Long userId; // USER 테이블과 조인할 key값

    @Column(name = "NICKNAME", length = 64, unique = true)
    @NotNull
    public String nickname;

    @Column(name="CATEGORY")
    public String category;

    @Column(name="AUTHOR", length = 64, unique = true)
    public String author;

    @Column(name="BOOK_TITLE", length = 200)
    public String bookTitle;

    @Column(name="CONTENT", length = 4000)
    public String content;

    @Column(name="BOOK_THUMBNAIL", length = 200)
    public String bookThumbnail;

    @Column(name = "LIKE_RATE", length = 64)
    public Long likeRate;

    /* 게시글 작성용 Post 엔티티 빌더 */
    @Builder
    public Posts(Long userId,
                 String nickname,
                 String author,
                 String category,
                 String bookTitle,
                 String content,
                 String bookThumbnail) {

        this.userId = userId;
        this.nickname = nickname;
        this.author = author;
        this.category = category;
        this.bookTitle = bookTitle;
        this.content = content;
        this.bookThumbnail = bookThumbnail;
    }

    public void update(String bookTitle, String content) {
        this.bookTitle = bookTitle;
        this.content = content;
    }
}
