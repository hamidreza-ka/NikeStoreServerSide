package com.hrk.nikestore.modules.comment.repository;

import com.hrk.nikestore.modules.comment.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    public List<Comment> findAllByProductId(Long id);
}
