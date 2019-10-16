package com.example.demo.controller;

import com.example.demo.model.FoodItemModel;
import com.example.demo.service.FoodItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/food-item")
public class FoodItemController {

    @Autowired
    private FoodItemService foodItemService;

    @GetMapping
    public String listAll(Model model) {
        model.addAttribute("foodItems", foodItemService.listAll());

        return "food-item/index";
    }

    @GetMapping("/create")
    public void create(Model model) {
        model.addAttribute("foodItemModel", new FoodItemModel());
    }

    @PostMapping("/save")
    public String create(@ModelAttribute FoodItemModel foodItemModel) {
        foodItemService.save(foodItemModel);

        return "redirect:/food-item";
    }

    @GetMapping("/delete")
    public FoodItemModel delete(int id) {
        return foodItemService.getFoodItemById(id);
    }

    @GetMapping("/edit")
    public FoodItemModel foodItemEditPage(int id){
        return foodItemService.getFoodItemById(id);
    }

    @PutMapping("/edit/save/")
    public String saveEditCourse(@ModelAttribute FoodItemModel foodItem, int id) {
        foodItemService.editFoodItem(foodItem, id);

        return "redirect:/food-item";
    }

    @DeleteMapping("/delete/confirm")
    public String deleteConfirmed(@ModelAttribute FoodItemModel foodItem, int id) {
        foodItemService.delete(foodItem, id);

        return "redirect:/food-item";
    }
}