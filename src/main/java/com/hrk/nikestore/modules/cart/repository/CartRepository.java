package com.hrk.nikestore.modules.cart.repository;

import com.hrk.nikestore.modules.cart.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    Cart getCartByUser_Id(Long userId);
}
