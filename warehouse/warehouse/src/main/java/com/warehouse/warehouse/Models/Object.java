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
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "address")
    private String address;
    @Column(name = "capacity")
    private Float capacity;
    @Column(name = "area")
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
    @JoinColumn(name= "order_id")
    private Order order;

    // Connection with TYPE table
    @OneToOne
    @JoinColumn(name = "type_id_fk", referencedColumnName = "id")
    private Type type;
}
