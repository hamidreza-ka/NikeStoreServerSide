package com.hrk.nikestore.modules.cart.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.gson.annotations.SerializedName;
import com.hrk.nikestore.modules.product.model.Product;
import javax.persistence.*;

@Entity(name = "cart_items")
public class CartItem {

    @Id
    @GeneratedValue
    private long cart_item_id;

    @OneToOne
    private Product product;

    private int count;

    @ManyToOne
    @JsonIgnore
    private Cart cart;

    public CartItem() {
    }

    public CartItem(Product product, int count, Cart cart) {
        this.product = product;
        this.count = count;
        this.cart = cart;
    }

    public long getCart_item_id() {
        return cart_item_id;
    }

    public void setCart_item_id(long id) {
        this.cart_item_id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
