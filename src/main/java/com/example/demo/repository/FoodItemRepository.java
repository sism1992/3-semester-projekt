package com.example.demo.repository;

import com.example.demo.model.FoodItemModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodItemRepository extends JpaRepository<FoodItemModel, Integer>{
}
