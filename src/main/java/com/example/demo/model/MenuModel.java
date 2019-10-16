package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "menu")
public class MenuModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int id;

    private Double price;

    private String name;
    private String description;

    @JsonIgnore
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "menu_food_item", joinColumns = @JoinColumn(name = "menu_id"),
            inverseJoinColumns = @JoinColumn(name = "food_item_id"))
    private List<FoodItemModel> foodItems = new ArrayList<>();

    @OneToMany (mappedBy = "menu")
    Set<OrderModel> orderModels = new HashSet<>();

    public void addFoodItem(FoodItemModel foodItemModel) {
        foodItems.add(foodItemModel);
        foodItemModel.getMenus().add(this);
    }

    public void deleteFoodItem(FoodItemModel foodItemModel){
        foodItems.remove(foodItemModel);
        foodItemModel.getMenus().remove(this);

    }

    // region getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<FoodItemModel> getFoodItems() {
        return foodItems;
    }

    public void setFoodItems(List<FoodItemModel> foodItems) {
        this.foodItems = foodItems;
    }
    // endregion
}
