package com.hrk.nikestore.modules.comment.model;

public class CommentRequest {
    private String title;
    private String content;
    private Long product_id;

    public CommentRequest() {
    }

    public CommentRequest(String title, String content, Long product_id) {
        this.title = title;
        this.content = content;
        this.product_id = product_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }
}
