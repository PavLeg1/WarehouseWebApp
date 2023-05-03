package com.warehouse.warehouse.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.util.Set;

@Entity
@Table(name= "order")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "date_of_order")
    private Date date_of_order;
    @Column(name = "status")
    private Boolean status;
    @Column(name = "profit")
    private Float profit;

    public void updateOrder(Order order){
        if(order.date_of_order != null) { this.date_of_order = order.date_of_order; }

        if(order.status != null)        { this.status = order.status; }

        if(order.profit != null)        { this.profit = order.profit; }
    }

    // Connection with OBJECT table
    @JsonIgnore
    @OneToMany(mappedBy = "order")
    private Set<Object> objects;


    // Connection with CLIENT table
    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;


    // Connection with STAFF table
    @ManyToOne
    @JoinColumn(name = "staff_id", nullable = false)
    private Staff staff;
}
