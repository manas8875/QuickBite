package com.project.QuickBite.service;

import com.project.QuickBite.model.Cart;
import com.project.QuickBite.model.Menu;
import com.project.QuickBite.model.User;
import com.project.QuickBite.repository.CartRepository;
import com.project.QuickBite.repository.MenuRepository;
import com.project.QuickBite.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MenuRepository menuRepository;

    public Cart addToCart(Long userId, Long itemId){
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        Menu item = menuRepository.findById(itemId).orElseThrow(()-> new RuntimeException("Item not found"));

        Cart cart = cartRepository.findByUser(user);
        if(cart == null){
            cart = new Cart();
            cart.setUser(user);
        }
        cart.getItems().add(item);
        return cartRepository.save(cart);
    }

    public Set<Menu> getCartItems(Long userId){
        User user = userRepository.findById(userId).orElseThrow(()->new RuntimeException("User not found"));
        Cart cart = cartRepository.findByUser(user);
        return cart != null ? cart.getItems() : Set.of();
    }

    public Cart removeFromCart(Long userId, Long itemId){
        User user = userRepository.findById(userId).orElseThrow(()->new RuntimeException("User not found"));
        Menu item = menuRepository.findById(itemId).orElseThrow(()-> new RuntimeException("Item not found"));
        Cart cart = cartRepository.findByUser(user);
        if(cart != null){
            cart.getItems().remove(item);
            return cartRepository.save(cart);
        }
        return null;
    }
}
