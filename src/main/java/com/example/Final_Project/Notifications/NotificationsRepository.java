package com.example.Final_Project.Notifications;

import com.example.Final_Project.Comments.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface NotificationsRepository extends JpaRepository<Notifications, Integer> {

    @Transactional
    @Modifying
    @Query("delete from Notifications l where l.post_id.post_id =:#{#post_id}")
    void deleteAllByPost_id(@Param("post_id") int post_id);
}