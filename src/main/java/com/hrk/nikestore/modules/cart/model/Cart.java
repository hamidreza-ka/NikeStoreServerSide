package com.hrk.nikestore.modules.cart.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hrk.nikestore.modules.user.model.User;
import javax.persistence.*;
import java.util.List;

@Entity
public class Cart {

    @Id
    @GeneratedValue
    @JsonIgnore
    private Long id;

    @OneToMany(mappedBy = "cart")
    List<CartItem> cartItems;

    @OneToOne
    @JsonIgnore
    private User user;

    private long payable_price = 0;
    private long total_price = 0;
    private int shipping_cost = 0;

    public Cart() {
    }

    public Cart(List<CartItem> cartItems, User user, long payable_price, long total_price, int shipping_cost) {
        this.cartItems = cartItems;
        this.user = user;
        this.payable_price = payable_price;
        this.total_price = total_price;
        this.shipping_cost = shipping_cost;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public long getPayable_price() {
        return payable_price;
    }

    public void setPayable_price(long payablePrice) {
        this.payable_price = payablePrice;
    }

    public long getTotal_price() {
        return total_price;
    }

    public void setTotal_price(long totalPrice) {
        this.total_price = totalPrice;
    }

    public int getShipping_cost() {
        return shipping_cost;
    }

    public void setShipping_cost(int shippingCost) {
        this.shipping_cost = shippingCost;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
