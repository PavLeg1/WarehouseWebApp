package main.java.com.warehouse.warehouse.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Entity
@Table(name= "order")
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Date date_of_order;
    private Boolean status;
    private Float profit;
}
