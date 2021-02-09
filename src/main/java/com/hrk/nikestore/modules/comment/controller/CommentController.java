package com.hrk.nikestore.modules.comment.controller;

import com.hrk.nikestore.modules.comment.model.Comment;
import com.hrk.nikestore.modules.comment.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {

    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Comment> getCommentsByProduct(@Param("id") Long id){
        return commentService.getComments(id);
    }
}
