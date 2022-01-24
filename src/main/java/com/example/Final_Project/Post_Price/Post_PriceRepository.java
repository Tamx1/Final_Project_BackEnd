package com.example.Final_Project.Post_Price;

import com.example.Final_Project.Comments.Comment;
import com.example.Final_Project.Users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface Post_PriceRepository extends JpaRepository<Post_Price, Integer> {
    @Query("select u from Post_Price u where u.post_id.post_id = :#{#postId}")
    Post_Price findByPost_id(@Param("postId") Integer postId);

    @Transactional
    @Modifying
    @Query("delete from Post_Price l where l.post_id.post_id =:#{#post_id}")
    void deleteAllByPost_id(@Param("post_id") int post_id);
}