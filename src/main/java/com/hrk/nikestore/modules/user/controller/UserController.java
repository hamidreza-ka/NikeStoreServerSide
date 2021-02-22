package com.hrk.nikestore.modules.user.controller;

import com.hrk.nikestore.modules.cart.service.CartService;
import com.hrk.nikestore.modules.user.model.User;
import com.hrk.nikestore.modules.user.model.UserRequest;
import com.hrk.nikestore.modules.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final CartService cartService;

    @Autowired
    public UserController(UserService userService, CartService cartService) {
        this.userService = userService;
        this.cartService = cartService;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public void registerUser(@RequestBody UserRequest request){
        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setName(request.getName());
        userService.registerUser(user);
        cartService.registerCart(user);
    }
}
