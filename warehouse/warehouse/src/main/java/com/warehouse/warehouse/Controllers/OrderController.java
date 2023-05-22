package com.warehouse.warehouse.Controllers;

import com.warehouse.warehouse.Exceptions.CustomNotFoundException;
import com.warehouse.warehouse.Exceptions.OrderNotFoundException;
import com.warehouse.warehouse.Models.Order;
import com.warehouse.warehouse.Services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/")
    public ResponseEntity<?> save(@RequestBody Order order){
        orderService.saveOrder(order);
        return ResponseEntity.ok().build();
    }

    @GetMapping("")
    public List<Order> getAll(){
        return orderService.getAllOrders();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        orderService.deleteOrder(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id){
        try{
            Order order =orderService.getOrderById(id);
            return ResponseEntity.ok(order);
        }
        catch(OrderNotFoundException ex){
            throw new CustomNotFoundException(HttpStatus.NOT_FOUND, "We're sorry to say that order with ID: " + id + " doesn't exist...");
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Order order, @PathVariable Integer id){
        try{
            Order _order = orderService.getOrderById(id);
            _order.updateOrder(order);
            orderService.saveOrder(_order);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (OrderNotFoundException ex){
            throw new CustomNotFoundException(HttpStatus.NOT_FOUND, "We're sorry to say that order with ID: " + id + " doesn't exist...");
        }
    }
}

