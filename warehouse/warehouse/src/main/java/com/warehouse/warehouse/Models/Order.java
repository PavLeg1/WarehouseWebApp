package com.warehouse.warehouse.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name= "orders")
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
    @Column(name = "profit") // Рассчитать base_price * area!!!
    private Float profit;

    public void updateOrder(Order order){
        if(order.date_of_order != null) { this.date_of_order = order.date_of_order; }

        if(order.status != null)        { this.status = order.status; }

        if(order.profit != null)        { this.profit = order.profit; }

        if(order.client != null)        {this.client = order.client; }

        if(order.staff != null)         {this.staff = order.staff; }

        if(order.objects != null)       {this.objects = order.objects; }
    }

    // Connection with OBJECT table
    @JsonIgnore
    @OneToMany(mappedBy = "order")
    private List<Object> objects;

    // Connection with CLIENT table
    @ManyToOne
    @JoinColumn(name = "clients_id_fk", referencedColumnName = "id")
    private Client client;


    // Connection with STAFF table
    @ManyToOne
    @JoinColumn(name = "staff_id_fk", referencedColumnName = "id")
    private Staff staff;
}
