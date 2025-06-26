package com.project.QuickBite.controller;


import com.project.QuickBite.model.Cart;
import com.project.QuickBite.model.Menu;
import com.project.QuickBite.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/{userId}/add/{itemId}")
    public Cart addItem(@PathVariable Long userId, @PathVariable Long itemId){
        return cartService.addToCart(userId, itemId);
    }

    @GetMapping("/{userId}")
    public Set<Menu> getCartItems(@PathVariable Long userId){
        return cartService.getCartItems(userId);
    }
    @DeleteMapping("/{userId}/remove/{itemId}")
    public Cart removeItem(@PathVariable Long userId, @PathVariable Long itemId){
        return cartService.removeFromCart(userId, itemId);
    }
}
