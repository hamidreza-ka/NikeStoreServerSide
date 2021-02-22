package com.hrk.nikestore.modules.comment.controller;

import com.google.gson.JsonObject;
import com.hrk.nikestore.modules.comment.model.Comment;
import com.hrk.nikestore.modules.comment.model.CommentRequest;
import com.hrk.nikestore.modules.comment.service.CommentService;
import com.hrk.nikestore.modules.product.service.ProductService;
import com.hrk.nikestore.modules.user.model.User;
import com.hrk.nikestore.modules.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/comment")
public class CommentController {

    private final CommentService commentService;
    private final UserService userService;


    @Autowired
    public CommentController(CommentService commentService, UserService userService, ProductService productService) {
        this.commentService = commentService;
        this.userService = userService;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Comment> getCommentsByProduct(@Param("id") Long id){
        return commentService.getComments(id);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Comment addComment(OAuth2Authentication auth2Authentication, @RequestBody CommentRequest request){
        Comment comment = new Comment();
        comment.setTitle(request.getTitle());
        comment.setContent(request.getContent());
        comment.setAuthor((User) userService.loadUserByUsername(auth2Authentication.getPrincipal().toString()));
        return commentService.addComment(comment, request.getProduct_id());
    }
}
