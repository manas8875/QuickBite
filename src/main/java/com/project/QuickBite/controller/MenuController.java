package com.project.QuickBite.controller;


import com.project.QuickBite.model.Menu;
import com.project.QuickBite.model.Restaurant;
import com.project.QuickBite.repository.MenuRepository;
import com.project.QuickBite.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/menu")
public class MenuController {
    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    @PostMapping("/restaurant/{restaurantId}")
    public Menu addItem(@PathVariable Long restaurantId, @RequestBody Menu item) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new RuntimeException("Restaurant not found"));

        item.setRestaurant(restaurant);
        return menuRepository.save(item);
    }

    @GetMapping("/restaurant/{restaurantId}")
    public List<Menu> getMenu(@PathVariable Long restaurantId){
        return menuRepository.findByRestaurantId(restaurantId);
    }
}
