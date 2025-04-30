package com.Ensam.blogg.repositories;

import com.Ensam.blogg.entities.Comment;
import com.Ensam.blogg.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Long> {


}
