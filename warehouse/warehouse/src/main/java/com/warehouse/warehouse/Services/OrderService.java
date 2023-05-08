package com.warehouse.warehouse.Services;

import com.warehouse.warehouse.Exceptions.OrderNotFoundException;
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

    public Order saveOrder(Order order){
        return orderRepo.save(order);
    }

    public Order getOrderById(Integer id){
        return orderRepo.findById(id).orElseThrow(() -> new OrderNotFoundException(id));
    }

    public void deleteOrder(Integer id){
        Order order = getOrderById(id);
        orderRepo.delete(order);
    }
}

