package com.hrk.nikestore.modules.cart.model.request;


public class AddCartItemRequest {

    private Long product_id;

    public AddCartItemRequest() {
    }

    public AddCartItemRequest(Long product_id) {
        this.product_id = product_id;
    }

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }
}
