package com.warehouse.warehouse.Services;

import com.warehouse.warehouse.Models.Order;
import com.warehouse.warehouse.Repos.OrderRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class OrderService {
    @Autowired
    private OrderRepo orderRepo;

    public List<Order> getAllOrders() {
        return orderRepo.findAll();
    }

    public void saveOrder(Order order){
        orderRepo.save(order);
    }

    public Order getOrderById(Integer id){
        return orderRepo.findById(id).get();
    }

    public void deleteOrder(Integer id){
        orderRepo.deleteById(id);
    }
}

