package com.warehouse.warehouse.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="object")
@Data
public class Object {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String description;
    private String address;
    private Float capacity;
    private Float area;

    public void updateObject(Object object) {
        if (object.name != null)        { this.name = object.name; }

        if (object.description != null) { this.description = object.description; }

        if (object.address != null)     { this.address = object.address; }

        if (object.capacity != null)    { this.capacity = object.capacity; }

        if(object.area != null)         { this.area = object.area; }
    }

    // Connection with ORDER table
    @ManyToOne
    @JoinColumn(name= "order_id", nullable = false)
    private Order order;

    // Connection with TYPE table
    @OneToOne
    @JoinColumn(name = "type_id")
    private Type type;
}
