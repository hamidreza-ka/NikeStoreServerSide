package com.hrk.nikestore.modules.comment.service;

import com.hrk.nikestore.modules.comment.model.Comment;
import com.hrk.nikestore.modules.comment.repository.CommentRepository;
import com.hrk.nikestore.modules.product.repository.ProductRepository;
import com.hrk.nikestore.modules.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final ProductRepository productRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository, ProductRepository productRepository) {
        this.commentRepository = commentRepository;
        this.productRepository = productRepository;
    }

    public List<Comment> getComments(Long productId){
        return commentRepository.findAllByProductId(productId);
    }

    public Comment addComment(Comment comment, Long productId){
        comment.setProduct(productRepository.getById(productId));
        return commentRepository.save(comment);
    }
}
