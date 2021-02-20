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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

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
    public CartItem addToCart(@RequestBody AddCartItemRequest addCartItemRequest) {
        return cartService.addToCart(addCartItemRequest.getProduct_id());
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Cart getCartItems(HttpServletRequest request) {
        User user = (User) userService.loadUserByUsername(request.getAttribute("user_name").toString());
        return cartService.getCartItems(user.getId());
    }

    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public ResponseEntity removeCartItem(@RequestBody RemoveCartItemRequest request) {
        return cartService.removeCartItem(request.getCart_item_id());
    }

    @RequestMapping(value = "/changeCount", method = RequestMethod.POST)
    public ResponseEntity changeCartItemCount(@RequestBody ChangeCountCartItemRequest request) {
        return cartService.changeCountCartItem(request.getCart_item_id(), request.getCount());
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    public ResponseEntity getCountOfCartItems(){
        return cartService.getCountOfCartItems();
    }

}
