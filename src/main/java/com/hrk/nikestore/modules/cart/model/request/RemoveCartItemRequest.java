package com.hrk.nikestore.modules.cart.model.request;

public class RemoveCartItemRequest {

    private Long cart_item_id;

    public RemoveCartItemRequest() {
    }

    public RemoveCartItemRequest(Long cart_item_id) {
        this.cart_item_id = cart_item_id;
    }

    public Long getCart_item_id() {
        return cart_item_id;
    }

    public void setCart_item_id(Long cart_item_id) {
        this.cart_item_id = cart_item_id;
    }
}
