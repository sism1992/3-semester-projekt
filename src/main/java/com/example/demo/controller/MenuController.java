package com.example.demo.controller;

import com.example.demo.model.MenuModel;
import com.example.demo.service.FoodItemService;
import com.example.demo.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @Autowired
    private FoodItemService foodItemService;

    @GetMapping
    public String menuPage(Model model, @RequestParam(defaultValue = "0") int page) {
        model.addAttribute("menus", menuService.listAll(page));
        model.addAttribute("currentPage", page);

        return "menu/index";
    }

    @GetMapping("/user-ui")
    public String userUI(Model model, @RequestParam(defaultValue = "0") int page) {
        model.addAttribute("menus", menuService.listAll(page));
        model.addAttribute("currentPage", page);

        return "menu/user-menu";
    }

    @GetMapping("/create")
    public void menuCreatePage(Model model) {
        model.addAttribute("menuModel", new MenuModel());
        model.addAttribute("foodItems", foodItemService.listAll());
    }

    @PostMapping("/save")
    public String saveCourse(@ModelAttribute MenuModel menuModel) {
        menuService.save(menuModel);

        return "redirect:/menu/";
    }

    @GetMapping("/find-one-json")
    @ResponseBody
    public MenuModel findOne(Integer id) {
        return menuService.findMenuById(id);
    }

    @GetMapping("/find-one")
    public String findMenuAndFood(Model model,@RequestParam("id") int id) {
        model.addAttribute("menuModel", menuService.getOne(id));
        return "menu/one";
    }

    @GetMapping("/edit")
    public void edit(Model model, int id) {
        model.addAttribute("menuModel", menuService.getOne(id));
        model.addAttribute("foodItems", foodItemService.listAll());
    }

    @PutMapping("/edit/save/")
    public String saveEditMenu(@ModelAttribute MenuModel menuModel, int id) {
        menuService.editMenu(menuModel, id);

        return "redirect:/menu";
    }

    @GetMapping("/delete")
    public MenuModel menuDeletePage ( int id) {
        return menuService.getOne(id);
    }

    @DeleteMapping("/delete/confirm")
    public String deleteConfirmed(@ModelAttribute MenuModel menuModel, int id) {
        menuService.delete(menuModel, id);
        return "redirect:/menu";
    }
}