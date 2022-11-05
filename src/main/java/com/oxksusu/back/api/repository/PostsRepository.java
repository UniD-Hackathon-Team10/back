package com.oxksusu.back.api.repository;

import com.oxksusu.back.api.entity.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;

@Repository
public interface PostsRepository extends JpaRepository<Posts, Long> {

    List<Posts> findAllByUserId(Long userId);

    Posts findByUserId(Long userId);
}
