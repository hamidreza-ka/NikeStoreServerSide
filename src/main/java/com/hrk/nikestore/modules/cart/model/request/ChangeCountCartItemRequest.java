package com.hrk.nikestore.modules.cart.model.request;

public class ChangeCountCartItemRequest {

    private Long cart_item_id;
    private int count;

    public ChangeCountCartItemRequest() {
    }

    public ChangeCountCartItemRequest(Long cart_item_id, int count) {
        this.cart_item_id = cart_item_id;
        this.count = count;
    }

    public Long getCart_item_id() {
        return cart_item_id;
    }

    public void setCart_item_id(Long cart_item_id) {
        this.cart_item_id = cart_item_id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
