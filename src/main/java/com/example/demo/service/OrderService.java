package com.example.demo.service;

import com.example.demo.model.MenuModel;
import com.example.demo.model.OrderModel;
import com.example.demo.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public void createOrder(OrderModel orderModel, MenuModel menuModel) {
        orderModel.setMenu(menuModel);
        orderRepository.save(orderModel);
    }

    public List<OrderModel> listAll() {
        return orderRepository.findAll();
    }

    public OrderModel getOne(int id) {
        return orderRepository.getOne(id);
    }

    public void editOrder(OrderModel orderModel, int id){
        orderModel.setId(id);
        orderRepository.save(orderModel);
    }

    public void delete(OrderModel orderModel, int id) {
        orderModel.setId(id);
        orderRepository.delete(orderModel);
    }
}
