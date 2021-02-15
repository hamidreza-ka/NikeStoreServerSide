package com.hrk.nikestore.modules.cart.repository;

import com.hrk.nikestore.modules.cart.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {

    List<CartItem> getCartItemsByCart_Id(Long cartId);
}
