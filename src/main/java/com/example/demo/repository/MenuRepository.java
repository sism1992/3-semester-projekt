package com.example.demo.repository;

import com.example.demo.model.MenuModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MenuRepository extends JpaRepository<MenuModel, Integer> {

    @Override
    List<MenuModel> findAll();

    @Override
    MenuModel getOne(Integer integer);
}
