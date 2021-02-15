package com.hrk.nikestore.modules.comment.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hrk.nikestore.modules.product.model.Product;
import com.hrk.nikestore.modules.user.model.User;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Comment {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String content;
    private String date;

    @ManyToOne
    @JsonIgnore
    private Product product;

    @ManyToOne
    private User author;


    public Comment() {
    }

    public Comment(Long id, String title, String content, String date, Product product, User author) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.date = date;
        this.product = product;
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
}
