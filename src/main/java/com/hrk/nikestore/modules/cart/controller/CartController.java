package com.hrk.nikestore.modules.cart.controller;

import com.hrk.nikestore.modules.cart.model.Cart;
import com.hrk.nikestore.modules.cart.model.CartItem;
import com.hrk.nikestore.modules.cart.model.request.AddCartItemRequest;
import com.hrk.nikestore.modules.cart.model.request.ChangeCountCartItemRequest;
import com.hrk.nikestore.modules.cart.model.request.RemoveCartItemRequest;
import com.hrk.nikestore.modules.cart.service.CartService;
import com.hrk.nikestore.modules.user.model.User;
import com.hrk.nikestore.modules.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;

    private final UserService userService;

    @Autowired
    public CartController(CartService cartService, UserService userService) {
        this.cartService = cartService;
        this.userService = userService;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public CartItem addToCart(OAuth2Authentication auth2Authentication, @RequestBody AddCartItemRequest addCartItemRequest) {
        User user = (User) userService.loadUserByUsername(auth2Authentication.getPrincipal().toString());
        return cartService.addToCart(user.getId(), addCartItemRequest.getProduct_id());
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Cart getCartItems(OAuth2Authentication auth2Authentication) {
        User user = (User) userService.loadUserByUsername(auth2Authentication.getPrincipal().toString());
        return cartService.getCartItems(user.getId());
    }

    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public ResponseEntity removeCartItem(OAuth2Authentication auth2Authentication, @RequestBody RemoveCartItemRequest request) {
        User user = (User) userService.loadUserByUsername(auth2Authentication.getPrincipal().toString());
        return cartService.removeCartItem(user.getId(), request.getCart_item_id());
    }

    @RequestMapping(value = "/changeCount", method = RequestMethod.POST)
    public ResponseEntity changeCartItemCount(OAuth2Authentication auth2Authentication, @RequestBody ChangeCountCartItemRequest request) {
        User user = (User) userService.loadUserByUsername(auth2Authentication.getPrincipal().toString());
        return cartService.changeCountCartItem(user.getId(), request.getCart_item_id(), request.getCount());
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    public ResponseEntity getCountOfCartItems(OAuth2Authentication auth2Authentication){
        User user = (User) userService.loadUserByUsername(auth2Authentication.getPrincipal().toString());
        return cartService.getCountOfCartItems(user.getId());
    }

}
