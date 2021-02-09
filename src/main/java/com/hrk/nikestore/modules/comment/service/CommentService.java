package com.hrk.nikestore.modules.comment.service;

import com.hrk.nikestore.modules.comment.model.Comment;
import com.hrk.nikestore.modules.comment.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public List<Comment> getComments(Long productId){
        return commentRepository.findAllByProductId(productId);
    }
}
