package com.project.QuickBite.service;

import com.project.QuickBite.controller.UserController;
import com.project.QuickBite.model.Cart;
import com.project.QuickBite.model.Menu;
import com.project.QuickBite.model.Order;
import com.project.QuickBite.model.User;
import com.project.QuickBite.repository.CartRepository;
import com.project.QuickBite.repository.OrderRepository;
import com.project.QuickBite.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private OrderRepository orderRepository;

    public Order placeOrder(Long userId){
        User user = userRepository.findById(userId).orElseThrow(()->new RuntimeException("User not found"));
        Cart cart = cartRepository.findByUser(user);
        if(cart == null || cart.getItems().isEmpty()){
            throw new RuntimeException("Cart is empty");
        }
        Order order = new Order();
        order.setUser(user);
        order.setOrderDate(LocalDateTime.now());
        order.setStatus("PLACED");
        order.setItems(List.copyOf(cart.getItems()));
        order.setAmount(cart.getItems().stream().mapToDouble(Menu::getPrice).sum());

        cart.getItems().clear();
        cartRepository.save(cart);
        return orderRepository.save(order);

    }

    public List<Order> getUserOrders(Long userId){
        User user = userRepository.findById(userId).orElseThrow(()->new RuntimeException("User not found"));
        return orderRepository.findByUser(user);
    }
}
