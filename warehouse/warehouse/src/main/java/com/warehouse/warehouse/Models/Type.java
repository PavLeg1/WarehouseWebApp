package com.warehouse.warehouse.Models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name= "types")
@Data
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String category;
    private Float size;
    private Float base_price; // Цена за квадратный метр, в зависимости от категории

    public void updateType(Type type){
        if(type.category != null) { this.category = type.category; }

        if(type.size != null)        {this.size = type.size; }

        if(type.base_price != null)  {this.base_price = type.base_price; }
    }

    // Connection with OBJECT table
    @OneToOne(mappedBy = "type")
    private Object object;
}
