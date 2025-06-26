package com.project.QuickBite.repository;

import com.project.QuickBite.model.Cart;
import com.project.QuickBite.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
    Cart findByUser(User user);
}
