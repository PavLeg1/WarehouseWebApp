package com.warehouse.warehouse.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name= "types")
@Data
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "category")
    private String category;
    @Column(name = "size")
    private Float size;
    @Column(name = "base_price")
    private Float base_price; // Цена за квадратный метр, в зависимости от категории

    public void updateType(Type type){
        if(type.category != null) { this.category = type.category; }

        if(type.size != null)        {this.size = type.size; }

        if(type.base_price != null)  {this.base_price = type.base_price; }

        if(type.object != null)      {this.object = type.object; }
    }

    // Connection with OBJECT table
    @JsonIgnore
    @OneToOne(mappedBy = "type")
    private Object object;
}
