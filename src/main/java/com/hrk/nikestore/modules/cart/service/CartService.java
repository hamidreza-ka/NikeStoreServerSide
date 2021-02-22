package com.hrk.nikestore.modules.cart.service;

import com.hrk.nikestore.modules.cart.model.Cart;
import com.hrk.nikestore.modules.cart.model.CartItem;
import com.hrk.nikestore.modules.cart.model.CartItemCount;
import com.hrk.nikestore.modules.cart.repository.CartItemRepository;
import com.hrk.nikestore.modules.cart.repository.CartRepository;
import com.hrk.nikestore.modules.common.ErrorResponse;
import com.hrk.nikestore.modules.common.MessageResponse;
import com.hrk.nikestore.modules.product.repository.ProductRepository;
import com.hrk.nikestore.modules.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;
    private final ProductRepository productRepository;

    @Autowired
    public CartService(CartRepository cartRepository, CartItemRepository cartItemRepository, ProductRepository productRepository) {
        this.cartRepository = cartRepository;
        this.cartItemRepository = cartItemRepository;
        this.productRepository = productRepository;
    }

    public void registerCart(User user) {
        cartRepository.save(new Cart(null, user, 0, 0, 0));
    }

    public CartItem addToCart(Long userId, Long productId) {
        Cart cart = cartRepository.getCartByUser_Id(userId);
        List<CartItem> cartItems = cartItemRepository.getCartItemsByCart_Id(cart.getId());
        for (CartItem cartItem : cartItems) {
            if (cartItem.getProduct().getId() == productId) {
                cartItem.setCount(cartItem.getCount() + 1);
                cartItemRepository.save(cartItem);
                return cartItem;
            }
        }

        CartItem newCartItem = new CartItem(productRepository.findById(productId).get(), 1, cart);
        cartItemRepository.save(newCartItem);
        return newCartItem;
    }

    public Cart getCartItems(Long userId) {
        Cart cart = cartRepository.getCartByUser_Id(userId);
        List<CartItem> cartItems = cartItemRepository.getCartItemsByCart_Id(cart.getId());
        Long totalPrice = 0L;
        Long payablePrice = 0L;

        for (CartItem cartItem : cartItems) {
            totalPrice += (cartItem.getProduct().getPrevious_price() * cartItem.getCount());
            payablePrice += (cartItem.getProduct().getPrice() * cartItem.getCount());
        }

        cart.setPayable_price(payablePrice);
        cart.setTotal_price(totalPrice);

        cartRepository.save(cart);
        return cart;
    }

    public ResponseEntity removeCartItem(Long userId, Long cartItemId) {
        try {
            List<CartItem> cartItems = cartItemRepository.getCartItemsByCart_Id(cartRepository.getCartByUser_Id(userId).getId());
            for (CartItem cartItem : cartItems) {
                if (cartItem.getCart_item_id() == cartItemId) {
                    cartItemRepository.deleteById(cartItemId);
                    MessageResponse messageResponse = new MessageResponse("محصول مورد نظر به درستی پاک شد");
                    return new ResponseEntity(messageResponse, HttpStatus.OK);
                }
            }
        } catch (Exception e) {
            ErrorResponse errorResponse = new ErrorResponse("Faild", "شناسه آیتم سبد خرید معتبر نیست");
            return new ResponseEntity(errorResponse, HttpStatus.UNPROCESSABLE_ENTITY);
        }

        ErrorResponse errorResponse = new ErrorResponse("Faild", "شناسه آیتم سبد خرید معتبر نیست");
        return new ResponseEntity(errorResponse, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    public ResponseEntity changeCountCartItem(Long userId, Long cartItemId, int count) {
        try {
            List<CartItem> cartItems = cartItemRepository.getCartItemsByCart_Id(cartRepository.getCartByUser_Id(userId).getId());
            for (CartItem cartItem : cartItems) {
                if (cartItem.getCart_item_id() == cartItemId) {
                    cartItem.setCount(count);
                    cartItemRepository.save(cartItem);
                    MessageResponse messageResponse = new MessageResponse("تعداد محصول مورد نظر به درستی تغییر کرد");
                    return new ResponseEntity(messageResponse, HttpStatus.OK);
                }
            }
        } catch (Exception e) {
            ErrorResponse errorResponse = new ErrorResponse("Faild", "شناسه آیتم سبد خرید معتبر نیست");
            return new ResponseEntity(errorResponse, HttpStatus.UNPROCESSABLE_ENTITY);
        }
        ErrorResponse errorResponse = new ErrorResponse("Faild", "شناسه آیتم سبد خرید معتبر نیست");
        return new ResponseEntity(errorResponse, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    public ResponseEntity getCountOfCartItems(Long userId){
        int count = 0;

        List<CartItem> cartItems = cartItemRepository.getCartItemsByCart_Id(cartRepository.getCartByUser_Id(1L).getId());
        for (CartItem cartItem : cartItems)
            count += cartItem.getCount();

        return new ResponseEntity(new CartItemCount(count), HttpStatus.OK);
    }
}
