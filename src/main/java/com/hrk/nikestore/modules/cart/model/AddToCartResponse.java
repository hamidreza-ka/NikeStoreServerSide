package com.hrk.nikestore.modules.cart.model;

public class AddToCartResponse {

    private Long id;
    private Long product_id;
    private int count;

    public AddToCartResponse() {
    }

    public AddToCartResponse(Long id, Long product_id, int count) {
        this.id = id;
        this.product_id = product_id;
        this.count = count;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
