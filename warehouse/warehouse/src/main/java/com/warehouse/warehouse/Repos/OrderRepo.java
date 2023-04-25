package com.warehouse.warehouse.Repos;

import com.warehouse.warehouse.Models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

public interface OrderRepo extends JpaRepository<Order, Integer> {
    //List<Order> findByDate(Date date_of_order);
}
