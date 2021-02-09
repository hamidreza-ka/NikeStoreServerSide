package com.hrk.nikestore.modules.product.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {

    @Id
    private Long id;
    private String title;
    private int price;
    private int discount;
    private String image;
    private int status;
    private int previous_price;

    public Product() {
    }

    public Product(Long id, String title, int price, int discount, String image, int status, int previous_price) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.discount = discount;
        this.image = image;
        this.status = status;
        this.previous_price = previous_price;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getPrevious_price() {
        return previous_price;
    }

    public void setPrevious_price(int previous_price) {
        this.previous_price = previous_price;
    }
}
